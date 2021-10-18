package com.idofast.proxy.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/10/18 11:55 下午
 */
@Configuration
@Slf4j
public class BeanConfig
{
    @Bean
    public ExecutorService v2rayGrpcAddPool()
    {
        return new ThreadPoolExecutor(1, 10, 5, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(10),
                new RejectedExecutionHandler()
                {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
                    {
                        log.warn("添加v2ray账户线程池满了");
                    }
                }
        );
    }
}
