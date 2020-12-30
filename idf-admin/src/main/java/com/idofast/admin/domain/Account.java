package com.idofast.admin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Account
{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition="bigint")
    protected Long id;

    @Column(updatable = false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间'",insertable = false)
    @CreationTimestamp
    protected LocalDateTime createTime;

    /**
     * 用户等级; 默认0
     */
    private Integer level;

    /**
     * 保留字段，兼容上个版本
     */
    private String accountNo;

    /**
     * 限速
     */
    private Long speed;

    /**
     *总流量
     */
    private Long totalData;

    /**
     * 已用流量
     */
    private Long usedData;

    /**
     * 下一个结算日期
     */
    private LocalDateTime nextSettleDate;

    /**
     * 过期时间
     */
    private LocalDateTime expireDate;


    private Long bundleType;


}
