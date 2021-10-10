package com.idofast.common.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/24 10:55 下午
 * 通用结果类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>
{
    //是否成功
    private boolean success;
    //如果成功，返回的数据
    private T data;
    //失败原因
    private String reason;

    public static <T> Result<T> ofSuccess(T t){
        return new Result<>(true, t, null);
    }

    public static <T> Result<T> ofFailed(){
        return new Result<T>(false, null, null);
    }

    public static <T> Result<T> ofFailed(String reason){
        return new Result<T>(false, null, reason);
    }
}
