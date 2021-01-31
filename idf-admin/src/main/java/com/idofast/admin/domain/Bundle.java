package com.idofast.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 套餐
 *
 * package是Java关键字
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bundle
{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition="bigint")
    private Long id;

    @Column(updatable = false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间'",insertable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '更新时间'",insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;

    private String name;

    /**
     * 套餐流量，单位MB
     */
    private Integer totalData;

    /**
     * 套餐速度
     */
    private Long speed;

    /**
     * 最大连接数
     */
    private Integer maxConnection;

    /**
     * 可用的服务器等级
     */
    private Integer level;

    /**
     * 套餐可用时间
     * 单位：天
     */
    private Integer duration;

    /**
     * 是否上线
     */
    @Column(nullable = false)
    private Boolean active;

    /**
     * 套餐描述
     */
    private String description;


    public static final Bundle DEFAULT_BUNDLE;

    static {
         DEFAULT_BUNDLE = new BundleBuilder()
                .speed(1024L)
                .duration(1)
                .level(0)
                .maxConnection(128)
                .totalData(2)
                .active(true)
                .name("默认初始套餐")
                .id(0L)
                .build();
    }


}
