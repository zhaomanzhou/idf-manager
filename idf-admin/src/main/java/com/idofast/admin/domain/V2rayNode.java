package com.idofast.admin.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/30 6:35 下午
 */

@Data
@Entity
public class V2rayNode
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


    /**
     * 节点名称
     */
    private String name;

    /**
     * 访问域名
     */
    private String host;

    /**
     * 服务器的ip
     */
    private String ip;

    /**
     * 访问端口
     */
    private Integer port;

    /**
     * 是否开启了tls
     */
    private Boolean supportTls;

    /**
     * 协议  wmess/vless
     */
    private String protocol;

    /**
     * 服务器是否上线
     */
    private Boolean enable;

    /**
     * 服务器等级
     */
    private  Integer level;

    /**
     * 流量倍率， 单位1/10；  值为10，代表倍率1
     */
    @Column(columnDefinition = "bigint not null default 10",nullable = false)
    private Integer magnification;

    /**
     * 服务器速率，单位mbps
     */
    @Column(columnDefinition = "int not null default 100",nullable = false)
    private Integer speed;



    /**
     * 节点描述
     */
    private String description;

    /**
     * 节点信息， 只有管理员可见
     */
    private String messageForAdmin;


    /**
     * 节点管理host
     */
    private String apiHost;

    /**
     * 节点管理端口
     */
    private Integer apiPort;


    /**
     * 排序使用
     */
    private Long sequence;



    /**
     * transitNode为true是有效， 父节点id
     */
    @Column(columnDefinition = "bigint not null default 0",nullable = false)
    private Long parentNodeId;






}
