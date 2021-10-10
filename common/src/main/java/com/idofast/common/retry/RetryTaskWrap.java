package com.idofast.common.retry;

import lombok.Data;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/25 8:13 下午
 */

@Data
class RetryTaskWrap<T>
{
    private RetryTask<T> task;

    private Long delay;

    private int retryTime;

    public RetryTaskWrap(RetryTask<T> task)
    {
        this.task = task;
        delay = 0L;
        retryTime = 0;
    }
}
