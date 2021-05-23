package com.idofast.common.schedule.retry;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:04 上午
 */
@Slf4j
public class RetryCommand<T>
{
    public T retryWithCondition(Callable<T> command, RetryFailedControl control, String description)
    {
        while (true)
        {
            if(control.getRetryTime() <= 0)
            {
                return null;
            }
            try
            {
                final T result = command.call();
                return result;
            } catch (Exception e)
            {
                log.warn("{}失败，失败原因{}, 还有{}次重试机会", description, e.getMessage(), control.getRetryTime());
                control.setRetryTime(control.getRetryTime() - 1);

                if(control.getRetryTime() > 0)
                {
                    try
                    {
                        Thread.sleep(control.getDelayTime());
                    } catch (InterruptedException interruptedException)
                    {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }
    }
}
