package com.idofast.admin.domain;

import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.enums.PayTypeEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 12:27 下午
 */

@Entity(name = "bundle_order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition="bigint")
    private Long id;

    @Column(updatable = false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间'",insertable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '更新时间'",insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Column(columnDefinition="TIMESTAMP NULL DEFAULT NULL comment '支付时间'",nullable = true)
    private LocalDateTime payTime;

    @Column(columnDefinition="TIMESTAMP NULL DEFAULT NULL comment '关闭时间'",nullable = true)
    private LocalDateTime closeTime;

    @Column(columnDefinition="TIMESTAMP NULL DEFAULT NULL comment '扫码时间'",nullable = true)
    private LocalDateTime scanTime;

    /**
     * 产生该订单的用户Id
     */
    private Long userId;
    /**
     * 套餐的Id
     */
    private Long bundleId;



    /**
     * 套餐购买了几个月
     */
    private Integer totalMonth;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 套餐总价
     */
    private Long totalMoney;


    /**
     * 支付方式；微信-支付宝
     */
    @Convert(converter=PayTypeEnum.Converter.class)
    private PayTypeEnum payType;

    /**
     * 交易方订单号
     */
    private String tradeNo;

    /**
     * 订单二维码
     */
    private String payLink;

    /**
     * 付款人id
     */
    private String buyerId;

    /**
     * 付款人支付宝账号
     */
    private String buyerLogonId;


    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;

}
