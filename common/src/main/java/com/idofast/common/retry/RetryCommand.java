package com.idofast.common.retry;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:08 上午
 * 重试命令，当抛出异常认为命令执行失败
 */
@Data
@Builder
public class RetryCommand<T>
{
    /**
     * 要执行的命令
     */
    private Callable<T> command;
    /**
     * 一共尝试几次
     */
    private int retryTime;

    /**
     * 失败后等多久进行重试
     */
    private Long delayTime;

    /**
     * 该命令的描述
     */
    private String name;


}
