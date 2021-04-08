package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.Bundle;
import com.idofast.admin.util.LocalDateTimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/1/25 9:53 下午
 */
@Data
@ApiModel("套餐返回的Vo对象")
public class BundleVo
{
    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("套餐创建时间")
    private Long createTime;

    @ApiModelProperty("套餐最近修改时间")
    private Long updateTime;

    @ApiModelProperty("套餐名称")
    private String name;

    @ApiModelProperty("套餐含有的总流量，单位MB")
    private Long totalData;

    @ApiModelProperty("套餐限制最大速度，0代表不限速，单位Mbps")
    private Long speed;

    @ApiModelProperty("套餐支持的最大TCP连接数")
    private Integer maxConnection;

    @ApiModelProperty("套餐对应的VIP等级，服务器限制用")
    private Integer level;

    @ApiModelProperty("套餐可用时间，单位天")
    private Integer duration;

    @ApiModelProperty("套餐是否上线")
    private Boolean active;

    @ApiModelProperty("套餐的描述")
    private String description;

    @ApiModelProperty("套餐的价格")
    private Long price;

    public static BundleVo convertFrom(Bundle bundle)
    {
        BundleVo bundleVo = new BundleVo();
        BeanUtils.copyProperties(bundle, bundleVo);
        bundleVo.setCreateTime(LocalDateTimeUtil.toTimeStamp(bundle.getCreateTime()));
        bundleVo.setUpdateTime(LocalDateTimeUtil.toTimeStamp(bundle.getUpdateTime()));
        return bundleVo;
    }
}
