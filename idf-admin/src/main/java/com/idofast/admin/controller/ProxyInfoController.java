package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.controller.vo.request.ProxyInfoUpdateVo;
import com.idofast.admin.controller.vo.request.UserSearchVo;
import com.idofast.admin.controller.vo.response.UserProxyInfoVo;
import com.idofast.admin.domain.User;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.dto.UserInfoLite;
import com.idofast.admin.service.UserProxyInfoService;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 12:32 上午
 */
@RestController
@RequestMapping("/proxyinfo")
@Api(tags = "用户代理信息相关的API")
@CrossOrigin
@Slf4j
@Validated
public class ProxyInfoController
{

    @Autowired
    private UserProxyInfoService userProxyInfoService;

    @GetMapping("/detail/{id}")
    @ApiOperation("根据id获取用户的系统信息")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<UserProxyInfoVo> getUserInformation(@PathVariable Long id) throws BusinessException
    {
        UserProxyInfo information = userProxyInfoService.selectById(id, false);
        return ServerResponse.success(UserProxyInfoVo.convertFrom(information));
    }

    @GetMapping("/email")
    @ApiOperation("根据email获取用户信息")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<Object> getUserProxyInfoByEmail(String email)
    {
        final List<UserProxyInfo> userInfoByEmail = userProxyInfoService.getUserInfoByEmail(email);
        return ServerResponse.success(userInfoByEmail);
    }

    @GetMapping("/id")
    @ApiOperation("根据email获取用户信息, 管理员查询其他用户使用")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<Object> getUserProxyInfoById(Long id)
    {
        final UserInfoLite userInfoByEmail = userProxyInfoService.getUserInfoById(id);
        return ServerResponse.success(userInfoByEmail);
    }

    @GetMapping("/detail")
    @ApiOperation("获取自己的系统信息")
    public ServerResponse<UserProxyInfoVo> getSelfInformation() throws BusinessException
    {
        User currentUser = RequestContext.getCurrentUser();
        UserProxyInfo information = userProxyInfoService.selectById(currentUser.getId(), true);
        return ServerResponse.success(UserProxyInfoVo.convertFrom(information));
    }

    @GetMapping("/list")
    @ApiOperation("获取用户列表")
    @AuthRole(RoleEnum.ADMIN)
    @Deprecated
    public ServerResponse<Object> getUserProxyInfoList()
    {
        Page<UserInfoLite> userList = userProxyInfoService.getUserList(null);
        return ServerResponse.success(userList);
    }





    @GetMapping("/list/page")
    @ApiOperation("获取用户列表")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<Object> getUserProxyInfoListPageable(UserSearchVo userSearchVo)
    {
        Page<UserInfoLite> userList = userProxyInfoService.getUserList(PageRequest.of(userSearchVo.getPage(),userSearchVo.getSize()));
        return ServerResponse.success(userList);
    }


    @GetMapping("/update")
    @ApiOperation("更改用户信息")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<Object> updateUserProxyInfo(@Validated ProxyInfoUpdateVo proxyInfoUpdateVo) throws BusinessException
    {
        userProxyInfoService.updateUserProxyInfo(proxyInfoUpdateVo);
        return ServerResponse.success();
    }









}
