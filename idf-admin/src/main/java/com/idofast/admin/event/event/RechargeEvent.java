package com.idofast.admin.event.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 10:31 上午
 */
public class RechargeEvent extends ApplicationEvent
{

    @Getter
    private Long orderId;

    @Getter
    private Long userId;

    @Getter
    private Integer period;

    @Getter
    private Long bundleId;

    /**
     * 是否是手动充值
     */
    @Getter
    private Boolean humanRecharge;

    public RechargeEvent(Object source, Long orderId, Long userId, Integer period, Long bundleId, Boolean humanRecharge)
    {
        super(source);
        this.orderId = orderId;
        this.userId = userId;
        this.period = period;
        this.bundleId = bundleId;
        this.humanRecharge = humanRecharge;
    }
}
