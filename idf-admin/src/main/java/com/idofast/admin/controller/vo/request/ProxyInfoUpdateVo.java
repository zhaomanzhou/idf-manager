package com.idofast.admin.controller.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/6 6:26 下午
 */
@Data
@ApiModel("修改用户代理信息的对象")
public class ProxyInfoUpdateVo
{
    @ApiModelProperty("用户的id")
    @NotNull
    private Long id;

    @ApiModelProperty("用户等级")
    private Integer level;

    @ApiModelProperty("限速值，单位kb/s")
    private Long speed;

    @ApiModelProperty("用户总流量")
    private Integer totalData;


    @ApiModelProperty("下一个结算日期；时间戳格式")
    private Long nextSettleDate;

    @ApiModelProperty("账号过期时间；时间戳格式")
    private Long expireDate;

    @ApiModelProperty("最大连接数")
    private Integer maxConnection;


    @ApiModelProperty("账号命名空间")
    private Integer namespace;
}
