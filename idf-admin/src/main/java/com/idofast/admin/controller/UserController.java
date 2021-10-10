package com.idofast.admin.controller;


import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.controller.vo.request.RegisterUserVo;
import com.idofast.admin.controller.vo.response.UserVo;
import com.idofast.admin.domain.User;
import com.idofast.admin.event.event.UserDisableEvent;
import com.idofast.admin.event.publisher.EventPublisher;
import com.idofast.admin.exception.BusinessErrorEnum;
import com.idofast.admin.service.EmailService;
import com.idofast.admin.service.UserService;
import com.idofast.common.enums.OsDeviceEnum;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.enums.UserStatusEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/user")
@Api(tags = "用户相关的api")
@CrossOrigin
@Slf4j
@Validated
public class UserController
{

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EventPublisher eventPublisher;




    @ApiOperation(value = "获取注册验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "string", example = "271832284@qq.com"),
    })
    @GetMapping("/vcode/register")
    public ServerResponse<String> registerForVcode(@Email(message = "邮箱格式不正确") @RequestParam("email") String email) throws Exception
    {
        if (StringUtils.isBlank(email))
        {
            throw new BusinessException("email不能为空");
        }
        boolean exist = userService.userExistByEmail(email);
        if (exist)
        {
            throw new BusinessException("用户已存在");
        }

        emailService.sendVcodeForRegister(email);
        return ServerResponse.success();
    }


    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ServerResponse<String> reg(@Validated RegisterUserVo registerUserVo) throws BusinessException
    {
        User user = userService.registerUser(registerUserVo);
        return ServerResponse.success();
    }


    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "用户邮箱", required = true, dataType = "string", example = "271832284@qq.com"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", example = "123456"),
    })
    @PostMapping(value = "/login")
    public ServerResponse<String> login(String email, String password) throws BusinessException
    {
        String token = userService.genTokenByAuthentication(email, password);
        return ServerResponse.success(token);
    }


    @ApiOperation("根据token获取当前用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token信息", required = true, dataType = "String"),
    })
    @GetMapping(value = "/detail/token")
    public ServerResponse<UserVo> getUserInfo(String token) throws BusinessException
    {

        if (token == null)
        {
            throw new BusinessException(BusinessErrorEnum.NEED_LOGIN);
        }

        User user = userService.getUserByToken(token);
        UserVo userVo = UserVo.convertUserToVo(user, true);
        return ServerResponse.success(userVo);

    }


    @ApiOperation(value = "根据id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
    })
    @GetMapping("/detail/id")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<UserVo> queryById(@NotNull Long id) throws BusinessException
    {
        User user = userService.getUserById(id);
        UserVo userVo = UserVo.convertUserToVo(user, false);
        return ServerResponse.success(userVo);
    }

    @ApiOperation(value = "通过旧密码来重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "passwordOld", value = "用户原密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passwordNew", value = "用户新密码", required = true, dataType = "String"),
    })
    @PostMapping(value = "/resetPassword/withOldPassword")
    public ServerResponse<String> resetPassword(@NotNull String passwordOld, @NotNull String passwordNew) throws BusinessException
    {
        User user = userService.getUserByToken(RequestContext.getToken());
        if (user == null)
        {
            return ServerResponse.error("用户未登录");
        }
        userService.resetPassword(passwordOld, passwordNew, user);
        return ServerResponse.success();
    }




    @ApiOperation(value = "注销用户")
    @PostMapping(value = "/delete")
    public ServerResponse<String> LogOutUser() throws BusinessException
    {
        User user = userService.getUserByToken(RequestContext.getToken());
        if (user == null)
        {
            return ServerResponse.error("用户未登录");
        }
        userService.deleteUser(user);
        return ServerResponse.success();
    }

    @ApiOperation(value = "更新用户备注")
    @AuthRole(RoleEnum.ADMIN)
    @PostMapping(value = "/update/remark")
    public ServerResponse<String> updateUserRemark(@NotNull Long userId, String newRemark)
    {
        userService.updateUserRemark(userId, newRemark);
        return ServerResponse.success();
    }

    @ApiOperation(value = "更新用户设备")
    @AuthRole(RoleEnum.ADMIN)
    @PostMapping(value = "/update/device")
    public ServerResponse<String> updateUserDevice(@NotNull Long userId,String[] newDevice)
    {
        List<OsDeviceEnum> list = new ArrayList<>();
        for (String device : newDevice)
        {
            OsDeviceEnum deviceEnum = OsDeviceEnum.ofMsg(device);
            if (deviceEnum != null)
            {
                list.add(deviceEnum);
            }
        }
        userService.updateUserDevice(userId, list);
        return ServerResponse.success();
    }


    @ApiOperation(value = "获取所有的设备信息")
    @AuthRole(RoleEnum.ADMIN)
    @GetMapping(value = "/device/list")
    public ServerResponse<List<String>> getDeviceList()
    {
        OsDeviceEnum[] values = OsDeviceEnum.values();
        List<String> collect = Arrays.stream(values).map(OsDeviceEnum::getMsg).collect(Collectors.toList());
        return ServerResponse.success(collect);
    }


    @ApiOperation(value = "修改用户状态")
    @AuthRole(RoleEnum.ADMIN)
    @PostMapping(value = "/status/update")
    public ServerResponse<String> updateUserStatus(@NotNull Long userId, @NotNull Boolean enable) throws BusinessException
    {
        UserStatusEnum toBeUpdated = enable ? UserStatusEnum.NORMAL : UserStatusEnum.FORBIDDEN;
        userService.updateUserStatus(userId, toBeUpdated);
        if(!enable)
        {
            eventPublisher.publishEvent(new UserDisableEvent(this, userId));
        }
        return ServerResponse.success();
    }


    @ApiOperation(value = "获取重置密码验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "string", example = "271832284@qq.com"),
    })
    @GetMapping("/vcode/resetPassword")
    public ServerResponse<String> resetPasswordForVcode(@Email(message = "邮箱格式不正确") @RequestParam("email") String email) throws Exception
    {
        if (StringUtils.isBlank(email))
        {
            throw new BusinessException("email不能为空");
        }
        boolean exist = userService.userExistByEmail(email);
        if (!exist)
        {
            log.warn("有用户尝试重置不存在email:{}的密码", email);
            return ServerResponse.success();
        }

        emailService.sendVcodeForResetPassword(email);
        return ServerResponse.success();
    }



    @ApiOperation(value = "通过验证码来重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "用户邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(name = "vcode", value = "用户验证码", required = true, dataType = "String"),
    })
    @PostMapping(value = "/resetPassword/withVcode")
    public ServerResponse<String> resetPasswordWithVcode(@NotNull String email, @NotNull String vcode, @NotNull String password) throws BusinessException
    {

        userService.resetPasswordByVcode(email, password, vcode);
        return ServerResponse.success();
    }
}
