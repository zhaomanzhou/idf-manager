package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.Order;
import com.idofast.common.util.LocalDateTimeUtil;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.enums.PayTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/5 8:40 下午
 */
@Data
@ApiModel("返回给用户的订单对象")
public class OrderToAdminDetailVo
{

    @ApiModelProperty("系统订单Id")
    private Long id;

    @ApiModelProperty("订单创建时间")
    private Long createTime;

    @ApiModelProperty("订单付款时间")
    private Long payTime;

    @ApiModelProperty("订单关闭时间")
    private Long closeTime;

    @ApiModelProperty("订单扫码时间")
    private Long scanTime;

    @ApiModelProperty("订单对应的套餐Id")
    private Long bundleId;

    @ApiModelProperty("购买了几个月的套餐")
    private Integer totalMonth;

    @ApiModelProperty("订单名称")
    private String orderName;


    @ApiModelProperty("订单总价")
    private Long totalMoney;

    @ApiModelProperty("订单支付方式")
    private PayTypeEnum payType;

    @ApiModelProperty("支付宝交易号")
    private String tradeNo;

    @ApiModelProperty("订单付款链接")
    private String payLink;

    @ApiModelProperty("订单状态")
    private OrderStatusEnum orderStatus;

    @ApiModelProperty("套餐名称")
    private String bundleName;

    @ApiModelProperty("下单用户id")
    private Long userId;

    @ApiModelProperty("下单用户email")
    private String userEmail;


    @ApiModelProperty("付款人支付宝id")

    private String buyerId;

    @ApiModelProperty("付款人支付宝账号")
    private String buyerLogonId;

    public static OrderToAdminDetailVo convertFromOrder(Order order)
    {
        OrderToAdminDetailVo vo = new OrderToAdminDetailVo();
        BeanUtils.copyProperties(order, vo);
        vo.setOrderName(order.getBundleName() + order.getTotalMonth() + "个月");
        vo.setCreateTime(LocalDateTimeUtil.toTimeStamp(order.getCreateTime()));
        vo.setPayTime(LocalDateTimeUtil.toTimeStamp(order.getPayTime()));
        vo.setCloseTime(LocalDateTimeUtil.toTimeStamp(order.getCloseTime()));
        vo.setScanTime(LocalDateTimeUtil.toTimeStamp(order.getScanTime()));
        return vo;
    }

}
