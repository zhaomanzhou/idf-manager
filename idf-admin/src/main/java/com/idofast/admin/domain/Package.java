package com.idofast.admin.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 套餐
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Package extends BaseEntity
{


    private String name;
    /**
     * 套餐流量
     */
    private int totalData;

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
    private Boolean active;

    /**
     * 套餐描述
     */
    private String description;


    public static final Package DEFAULT_PACKAGE;

    static {
       DEFAULT_PACKAGE = new Package.PackageBuilder()
                .speed(1024L)
                .duration(1)
                .level(0)
                .maxConnection(128)
                .totalData(2)
                .active(true)
                .name("默认初始套餐")
                .build();
        //lombok  builder不能继承
        DEFAULT_PACKAGE.setId(0L);

    }

    static class PackageBuilder
    {

    }
}
