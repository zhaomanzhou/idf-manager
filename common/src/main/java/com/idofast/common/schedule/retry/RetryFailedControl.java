package com.idofast.common.schedule.retry;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:08 上午
 */
@Data
@Builder
public class RetryFailedControl
{
    /**
     * 一共尝试几次
     */
    private int retryTime;

    /**
     * 失败后等多久进行重试
     */
    private Long delayTime;


}
