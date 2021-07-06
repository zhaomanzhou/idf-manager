package com.idofast.admin.controller.vo.request;

import lombok.Data;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/6/18 4:19 下午
 */
@Data
public class UserSearchVo
{
    /**
     * 第几页
     */
    private Integer page;
    /**
     * 每页多少
     */
    private Integer size;

}
