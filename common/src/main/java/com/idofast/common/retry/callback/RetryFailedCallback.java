package com.idofast.common.retry.callback;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/27 12:16 上午
 */
@FunctionalInterface
public interface RetryFailedCallback
{

        /**
         * 任务失败回调
         * @param retryTime 任务执行的次数，第一次回调参数值位1 | 也可以理解为即将执行第几次重试
         * @param prevDelayTime 上一次等待时间
         * @return  -1  结束任务  >= 0 等待多久执行，单位ms
         *
         */
        Long nextDelayTime(int retryTime, Long prevDelayTime);

}
