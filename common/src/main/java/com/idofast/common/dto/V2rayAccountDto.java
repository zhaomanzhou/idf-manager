package com.idofast.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 1:11 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class V2rayAccountDto
{

    /**
     * 用户的id
     */
    private Long id;

    /**
     * 用户的邮箱
     */
    private String email;

    private Long speed;

    /**
     *可用流量,单位kb
     */
    private Long availableData;

    /**
     * 过期时间
     */
    private Long expireDate;

    /**
     * 最大连接数
     */
    private Integer maxConnection;

    /**
     * uuid
     */
    private String uuid;


}
