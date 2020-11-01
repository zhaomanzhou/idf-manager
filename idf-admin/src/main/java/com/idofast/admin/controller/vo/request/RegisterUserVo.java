package com.idofast.admin.controller.vo.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户注册的vo对象")
public class RegisterUserVo
{
    @NotNull
    @Email
    @ApiModelProperty("邮箱")
    private String email;

    @NotNull
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String ncikname;

    @NotNull
    @ApiModelProperty("验证码")
    private String vcode;

    @ApiModelProperty("邀请吗")
    private String inviteCode;
}
