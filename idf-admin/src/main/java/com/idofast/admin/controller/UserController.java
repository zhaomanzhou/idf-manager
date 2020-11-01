package com.idofast.admin.controller;


import com.idofast.admin.controller.vo.request.RegisterUserVo;
import com.idofast.admin.service.EmailService;
import com.idofast.admin.service.UserService;
import com.idofast.admin.vo.UserVo;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Validator;
import javax.validation.constraints.Email;
import java.io.UnsupportedEncodingException;
import java.util.Date;

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
    private Validator validator;

    @ApiOperation(value = "获取注册验证码" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true,dataType = "string",example = "271832284@qq.com"),
    })
    @GetMapping("/vcode/register")
    public ServerResponse<String> registerForVcode(@Email(message = "邮箱格式不正确") @RequestParam("email") String email) throws Exception
    {
        if(StringUtils.isBlank(email))
        {
            throw new BusinessException("email不能为空");
        }
        boolean exist = userService.userExistByEmail(email);
        if(exist)
        {
            throw new BusinessException("用户已存在");
        }

        emailService.sendVcodeForRegister(email);
        return ServerResponse.success();
    }



    @PostMapping("/reg")
    public ServerResponse<String> reg(@RequestBody RegisterUserVo registerUserVo) throws BusinessException
    {
        emailService.registerUser(registerUserVo);
        return ServerResponse.success();
    }
}
