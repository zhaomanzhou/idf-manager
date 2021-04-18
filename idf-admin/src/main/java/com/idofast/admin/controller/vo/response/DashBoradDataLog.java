package com.idofast.admin.controller.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/18 12:32 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashBoradDataLog
{
    private String date;
    //单位MB
    private Integer flow;
}
