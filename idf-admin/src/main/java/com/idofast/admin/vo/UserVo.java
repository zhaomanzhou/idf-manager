package com.idofast.admin.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
@ApiModel("用户好友的VO对象")
public class UserVo
{

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名")
    private String nickname;

    @ApiModelProperty("用户邮箱")
    private String email;


    private String avatarUrl;

    private String password;

    private Integer role;


    private Integer status;

    //备注
    private String remark;

    //使用的设备
    private List<Integer> osDevice;

    private String ext;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;


}
