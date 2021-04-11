package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.controller.vo.request.V2rayNodeAddOrUpdateVo;
import com.idofast.admin.controller.vo.response.DirectV2rayNodeVo;
import com.idofast.admin.controller.vo.response.V2rayNodeVo;
import com.idofast.admin.domain.V2rayNode;
import com.idofast.admin.service.NodeService;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/10 8:02 下午
 */

@RestController
@RequestMapping("/node")
@Api(tags = "服务器节点相关的api")
@CrossOrigin
@Slf4j
@Validated
public class NodeController
{

    @Autowired
    private NodeService nodeService;

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

    @GetMapping("/v2ray/list")
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

}
