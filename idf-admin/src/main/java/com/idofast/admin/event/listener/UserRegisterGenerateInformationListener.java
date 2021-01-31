package com.idofast.admin.event.listener;

import com.idofast.admin.domain.UserInformation;
import com.idofast.admin.event.event.UserRegisterEvent;
import com.idofast.admin.repository.UserInformationRepository;
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
    private UserInformationRepository userInformationRepository;

//    @Async
    @Override
    public void onApplicationEvent(UserRegisterEvent event)
    {
        LocalDateTime now = LocalDateTime.now();
        Long id = event.getId();
        UserInformation information = UserInformation.builder()
                .id(id)
                .level(0)
                .speed(1024)
                .totalData(1024)
                .usedData(0)
                .nextSettleDate(now.plusDays(1))
                .expireDate(now.plusDays(1))
                .packageId(0)
                .namespace(0)
                .diable(false)
                .deleted(DeletedEnum.NORMAL)
                .build();
        userInformationRepository.save(information);
    }
}
