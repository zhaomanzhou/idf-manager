package com.idofast.admin.event.listener;

import com.idofast.admin.event.event.UserDisableEvent;
import com.idofast.admin.service.V2rayApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/14 7:52 下午
 */
@Component
public class UserDisableListener implements ApplicationListener<UserDisableEvent>
{

    @Autowired
    private V2rayApiService v2rayApiService;

    @Async
    @Override
    public void onApplicationEvent(UserDisableEvent userDisableEvent)
    {
        Long id = userDisableEvent.getId();
        v2rayApiService.rmRemoteAccount(id);
    }
}
