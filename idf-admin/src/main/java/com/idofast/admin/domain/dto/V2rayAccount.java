package com.idofast.admin.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:26 下午
 * jpa数据类型一定要和表一直，因此不能查询直接返回V2rayAccountDto，所以需要这个中间对象
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class V2rayAccount
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
    private Long userData;

    private Long totalDate;

    /**
     * 过期时间
     */
    private LocalDateTime expireDate;

    /**
     * 最大连接数
     */
    private Integer maxConnection;

    /**
     * uuid
     */
    private String uuid;
}
