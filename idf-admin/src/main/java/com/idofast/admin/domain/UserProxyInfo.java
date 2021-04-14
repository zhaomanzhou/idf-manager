package com.idofast.admin.domain;

import com.idofast.common.enums.DeletedEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=0")
@Table( indexes = {
        @Index(name = "idx_next_settle_user", columnList="nextSettleDate", unique = false),
        @Index(name = "idx_expire_date_user", columnList="expireDate", unique = false),
        @Index(name = "idx_bundle_id_date_user", columnList="bundleName", unique = false),
})
public class UserProxyInfo
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
     * 用户等级; 默认0
     */
    @Column(nullable = false)
    private Integer level;


    /**
     * 限速,单位kbps
     */
    @Column(nullable = false)
    private Long speed;

    /**
     *总流量,单位kb
     */
    @Column(nullable = false)
    private Long totalData;

    /**
     * 已用流量 kb
     */
    @Column(nullable = false)
    private Long usedData;

    /**
     * 下一个结算日期
     */
    @Column(nullable = false)
    private LocalDateTime nextSettleDate;

    /**
     * 过期时间
     */
    @Column(nullable = false)
    private LocalDateTime expireDate;

    /**
     * 最大连接数, 0表示不限制
     */
    @Column(nullable = false)
    private Integer maxConnection;

    /**
     * 目前使用的套餐ID
     */
    @Column(nullable = false)
    private Long bundleId;

    /**
     * 目前使用的套餐名
     */
    @Column(nullable = false)
    private String bundleName;


    /**
     * 账号命名空间
     */
    @Column(nullable = false)
    private Integer namespace;


    /**
     * 账号总付费了多少天
     */
    private Integer totalActiveDay;

    /**
     * 账号是否被删除
     */
    private DeletedEnum deleted;


    /**
     * 订阅链接的码
     */
    private String subscribeCode;


    /**
     * v2ray账号的uuid
     */
    private String uuid;
}
