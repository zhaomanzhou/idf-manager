package com.idofast.common.retry;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/25 7:54 下午
 */
public class RetryTaskExecutor
{

    private ScheduledExecutorService scheduledService = new ScheduledThreadPoolExecutor(2,
            new CustomizableThreadFactory("scheduled-retry-task"));


    public <T> void submitTask(RetryTask<T> task)
    {
        RetryTaskWrap<T> taskWrap = new RetryTaskWrap<>(task);
        schedule(taskWrap);

    }

    private <T> void schedule(RetryTaskWrap<T> taskWrap)
    {
        scheduledService.schedule(() -> {
            try
            {
                final T result = taskWrap.getTask().getTask().call();
                taskWrap.getTask().getSuccessCallback().accept(result);
            } catch (Exception e)
            {
                taskWrap.setRetryTime(taskWrap.getRetryTime() + 1);
                Long delayTime = taskWrap.getTask().getFailedCallback().nextDelayTime(taskWrap.getRetryTime(), taskWrap.getDelay());
                if(delayTime < 0){
                    return;
                }
                taskWrap.setDelay(delayTime);
                schedule(taskWrap);
            }
        }, taskWrap.getDelay(), TimeUnit.MILLISECONDS);

    }


    public void shutdown()
    {
        scheduledService.shutdown();
    }
}
