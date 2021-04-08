package com.idofast.admin.event.listener;

import com.idofast.admin.domain.Bundle;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.event.event.UserRegisterEvent;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.admin.service.manager.SystemPreferenceManager;
import com.idofast.common.enums.DeletedEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/30 11:30 下午
 */
@Component
public class UserRegisterGenerateInformationListener implements ApplicationListener<UserRegisterEvent>
{

    @Autowired
    private UserProxyInfoRepository userProxyInfoRepository;

    @Autowired
    private SystemPreferenceManager preferenceManager;


//    @Async
    @Override
    public void onApplicationEvent(UserRegisterEvent event)
    {
        Integer freeUseTime = preferenceManager.getFreeUseTime();


        Bundle defaultBundle = Bundle.DEFAULT_BUNDLE;
        LocalDateTime now = LocalDateTime.now();
        Long id = event.getId();
        UserProxyInfo information = UserProxyInfo.builder()
                .id(id)
                .level(defaultBundle.getLevel())
                .speed(defaultBundle.getSpeed())
                .totalData(defaultBundle.getTotalData())
                .usedData(0L)
                .nextSettleDate(now.plusMinutes(freeUseTime))
                .expireDate(now.plusMinutes(freeUseTime))
                .bundleId(defaultBundle.getId())
                .namespace(0)
                .totalActiveDay(0)
                .maxConnection(defaultBundle.getMaxConnection())
                .bundleName(defaultBundle.getName())
                .deleted(DeletedEnum.NORMAL)
                .build();
        userProxyInfoRepository.insertWithGivenId(information);
    }
}
