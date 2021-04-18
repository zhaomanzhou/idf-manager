package com.idofast.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.controller.vo.request.V2rayNodeAddOrUpdateVo;
import com.idofast.admin.controller.vo.response.DirectV2rayNodeVo;
import com.idofast.admin.controller.vo.response.ServerBasedOnlineStatus;
import com.idofast.admin.controller.vo.response.ServerNodeResponse;
import com.idofast.admin.controller.vo.response.V2rayNodeVo;
import com.idofast.admin.domain.User;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.V2rayNode;
import com.idofast.admin.service.ConnectionService;
import com.idofast.admin.service.NodeService;
import com.idofast.admin.service.UserProxyInfoService;
import com.idofast.admin.service.UserService;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/10 8:02 下午
 */

@RestController
@RequestMapping("/server")
@Api(tags = "服务器节点相关的api")
@CrossOrigin
@Slf4j
@Validated
public class ServerNodeController
{

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private UserProxyInfoService proxyInfoService;

    @Autowired
    private UserService userService;


    Cache<Long, User> userInformationCache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.DAYS).build();
    Cache<String, Optional<V2rayNode>> nodeCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build();


    @PostMapping("/v2ray/add")
    @ApiOperation(value = "添加v2ray节点")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String> createV2rayNode(@Validated V2rayNodeAddOrUpdateVo nodeAddVo)
    {
        V2rayNode node = V2rayNodeAddOrUpdateVo.convertToV2rayNode(nodeAddVo);
        nodeService.addNewV2rayNode(node);
        return ServerResponse.success();
    }

    @GetMapping("/v2ray/direct/list")
    @ApiOperation("获取所有直连列表")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<List<DirectV2rayNodeVo>> getSimpleDirectNodeList()
    {
        List<DirectV2rayNodeVo> allDirectNodes = nodeService.getAllDirectNodes();
        return ServerResponse.success(allDirectNodes);
    }

    @GetMapping("/v2ray/admin/list")
    @ApiOperation("获取所有v2ray节点列表")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<List<V2rayNodeVo>> getAllV2rayNode()
    {
        List<V2rayNodeVo> allV2rayNodes = nodeService.getAllV2rayNodes();
        return ServerResponse.success(allV2rayNodes);
    }


    @PostMapping("/v2ray/delete")
    @ApiOperation("删除v2ray节点列表")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String> deleteV2rayNode(@NotNull Long id)
    {
        nodeService.deleteNode(id);
        return ServerResponse.success();
    }

    @PostMapping("/v2ray/update")
    @ApiOperation(value = "修改v2ray节点")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String> updateV2rayNode(@Validated V2rayNodeAddOrUpdateVo nodeAddVo)
    {
        V2rayNode node = V2rayNodeAddOrUpdateVo.convertToV2rayNode(nodeAddVo);
        nodeService.addNewV2rayNode(node);
        return ServerResponse.success();
    }

    @GetMapping("/v2ray/list")
    @ApiOperation(value = "普通用户获取v2ray节点列表")
    public ServerResponse<Map<Integer, List<ServerNodeResponse>>> getV2rayNodeList() throws BusinessException
    {

        UserProxyInfo proxyInfo = proxyInfoService.selectById(RequestContext.getCurrentUser().getId(), false);
        Map<Integer, List<V2rayNode>> nodeListForSimpleUser = nodeService.getNodeListForSimpleUser();

        Map<Integer, List<ServerNodeResponse>> collect = nodeListForSimpleUser.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(k -> ServerNodeResponse.convertFrom(k, proxyInfo.getLevel(), connectionService.getConnectionNumByHost(k.getHost())))
                                .collect(Collectors.toList())
                        )
                );
        return ServerResponse.success(collect);
    }

    @ApiOperation("获取服务器在线人数，以服务器进行分组")
    @GetMapping("/online/byNode")
    public ServerResponse<List<ServerBasedOnlineStatus>> getOnlineUserList()
    {
        ConcurrentMap<String, ConcurrentHashMap<Long, Integer>> serverCache = connectionService.getServerCache();
        List<ServerBasedOnlineStatus> result = new ArrayList<>();
        for (Map.Entry<String, ConcurrentHashMap<Long, Integer>> entrys : serverCache.entrySet())
        {
            ServerBasedOnlineStatus status = new ServerBasedOnlineStatus();
            status.setHost(entrys.getKey());

            try
            {
                Optional<V2rayNode> v2rayNode = nodeCache.get(entrys.getKey(), () -> nodeService.getByHost(entrys.getKey()));
                v2rayNode.ifPresent(node -> status.setName(node.getName()));
            } catch (ExecutionException e)
            {
                log.error("获取在线用户时，根据服务器host查服务器时发生了异常", e);
                continue;
            }

            List<ServerBasedOnlineStatus.UserWithConnectionNum> list = new ArrayList<>();
            ConcurrentHashMap<Long, Integer> userConnectionMap = entrys.getValue();
            for (Map.Entry<Long, Integer> entry : userConnectionMap.entrySet())
            {
                try
                {
                    User user = userInformationCache.get(entry.getKey(), () -> userService.getUserById(entry.getKey()));
                    ServerBasedOnlineStatus.UserWithConnectionNum userWithConnectionNum = new ServerBasedOnlineStatus.UserWithConnectionNum();
                    BeanUtil.copyProperties(user, userWithConnectionNum);
                    userWithConnectionNum.setConnectionNum(entry.getValue());
                    userWithConnectionNum.setPassword("");
                    list.add(userWithConnectionNum);
                } catch (ExecutionException e)
                {
                    log.error("获取在线用户时，根据用户id查用户发生了异常", e);
                    continue;
                }
            }

            status.setUsers(list);
            result.add(status);
        }

        return ServerResponse.success(result);
    }

}
