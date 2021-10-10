package com.idofast.common.retry;

import com.idofast.common.retry.callback.RetryFailedCallback;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:08 上午
 * 重试任务，异步执行，当抛出异常认为命令执行失败
 */
@Data
@Builder
public class RetryTask<T>
{
    /**
     * 要执行的命令
     */
    private Callable<T> task;

    /**
     * 该命令的描述
     */
    private String name;

    /**
     * 任务失败的回调
     */
    private RetryFailedCallback failedCallback;

    /**
     * 任务成功后的回调
     */
    private Consumer<T> successCallback;

}


