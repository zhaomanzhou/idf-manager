package com.idofast.common.retry;

import com.idofast.common.common.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:04 上午
 */
@Slf4j
public class RetryUtil
{

    public static <T> Result<T> syncRetry(RetryCommand<T> retryCommand)
    {
        for (int i = 0; i < retryCommand.getRetryTime(); i++)
        {
            try
            {
                final T call = retryCommand.getCommand().call();
                return Result.ofSuccess(call);
            } catch (Exception e)
            {
                if(retryCommand.getDelayTime() > 0)
                {
                    try
                    {
                        Thread.sleep(retryCommand.getDelayTime());
                    } catch (InterruptedException interruptedException)
                    {
                        //ignore
                    }
                }
                //ignore
            }
        }

        return Result.ofFailed();
    }


}
