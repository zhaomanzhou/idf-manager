package com.idofast.common.retry;

import com.idofast.common.retry.callback.RetryFailedCallback;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/27 12:43 上午
 */
public class RetryTaskExecutorTest
{

    static int counter = 0;
    @Test
    public void testSubmitTask() throws InterruptedException
    {
        Callable<String> command = () -> {
            counter++;
            if(counter < 10) throw new RuntimeException();else return "哈哈哈成功了";
        };

        RetryFailedCallback failedCallback1 = ((retryTime, prevDelayTime) -> {
            System.out.println("Task1-----------第" + retryTime + "次失败\t 等待" + 1000L + "ms后去执行");
            if(retryTime > 5)
            {
                System.out.println("Task1-----------算了，放弃了！");
                return -1L;
            }
            return 1000L;
        });

        RetryFailedCallback failedCallback2 = ((retryTime, prevDelayTime) -> {
            System.out.println("Task2+++++++++++++第" + retryTime + "次失败\t 等待" + 1000L * retryTime + "ms后去执行");
            if(retryTime > 5)
            {
                System.out.println("Task2+++++++++++算了，放弃了！");
                return -1L;
            }
            return 1000L * retryTime;
        });

        RetryTaskExecutor taskExecutor = new RetryTaskExecutor();
        RetryTask<String> task1 = RetryTask.<String>builder()
                .task(command)
                .failedCallback(failedCallback1)
                .successCallback((t) -> { System.out.println("耶，任务成功了！"); })
                .name("测试任务")
                .build();

        RetryTask<String> task2 = RetryTask.<String>builder()
                .task(command)
                .failedCallback(failedCallback2)
                .successCallback((t) -> { System.out.println("耶，任务成功了！"); })
                .name("测试任务")
                .build();

        taskExecutor.submitTask(task1);
        taskExecutor.submitTask(task2);
        TimeUnit.HOURS.sleep(2);
    }
}