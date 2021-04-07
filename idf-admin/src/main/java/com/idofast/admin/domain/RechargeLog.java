package com.idofast.admin.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 4:16 下午
 */

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( indexes = {
        @Index(name = "idx_order_id", columnList="orderId", unique = false),
})

public class RechargeLog
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


    /**
     * 充值的对象
     */
    private Long userId;

    /**
     * 对应的订单Id
     */
    private Long orderId;

    /**
     * 是否手工充值
     */
    private Boolean humanRecharge;

    /**
     * 充值的套餐Id
     */
    private Long bundleId;

    /**
     * 充值的套餐名
     */
    private String bundleName;

    /**
     * 套餐周期天数
     */
    private Integer duration;

    /**
     * 充值了几个
     */
    private Integer rechargeNum;

    /**
     * 充值前到期时间
     */
    private LocalDateTime prevExpireDate;

    /**
     * 充值前的套餐Id
     */
    private Long prevBundleId;


    /**
     * 充值前的套餐名
     */
    private String prevBundleName;


}
