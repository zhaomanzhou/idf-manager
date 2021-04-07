package com.idofast.admin.event.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/5 9:06 下午
 */

/**
 * 用户被封禁发送的广播
 *
 * //TODO 禁止登陆。。。
 */
public class UserDisableEvent extends ApplicationEvent
{
    @Getter
    private Long id;

    public UserDisableEvent(Object source, Long id)
    {
        super(source);
        this.id = id;
    }
}
