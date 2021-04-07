package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.util.LocalDateTimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
@ApiModel("用户系统信息返回的vo对象；流量，到期时间等")
public class UserProxyInfoVo
{

    @ApiModelProperty("用户的id")
    private Long id;

    @ApiModelProperty("用户等级")
    private Integer level;

    @ApiModelProperty("限速值，单位kb/s")
    private Long speed;

    @ApiModelProperty("用户总流量")
    private Integer totalData;

    @ApiModelProperty("用户已用流量")
    private Integer usedData;

    @ApiModelProperty("下一个结算日期；时间戳格式")
    private Long nextSettleDate;

    @ApiModelProperty("账号过期时间；时间戳格式")
    private Long expireDate;

    @ApiModelProperty("最大连接数")
    private Integer maxConnection;

    @ApiModelProperty("账号用的套餐Id")
    private Long bundleId;

    @ApiModelProperty("账号用的套餐名")
    private String bundleName;

    @ApiModelProperty("账号已开通的会员天数")
    private Integer totalActiveDay;

    @ApiModelProperty("账号命名空间")
    private Integer namespace;


    public static UserProxyInfoVo convertFrom(UserProxyInfo userProxyInfo){
        UserProxyInfoVo vo = new UserProxyInfoVo();
        BeanUtils.copyProperties(userProxyInfo, vo);
        vo.setNextSettleDate(LocalDateTimeUtil.toTimeStamp(userProxyInfo.getNextSettleDate()));
        vo.setExpireDate(LocalDateTimeUtil.toTimeStamp(userProxyInfo.getExpireDate()));
        return vo;
    }


}
