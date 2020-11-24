package com.idofast.admin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Account extends BaseEntity
{

    /**
     * 用户等级; 默认0
     */
    private Integer level;

    /**
     * 保留字段，兼容上个版本
     */
    private String accountNo;

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
