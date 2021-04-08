package com.idofast.admin.service.manager;

import com.idofast.admin.domain.enums.SystemPreferenceEnum;
import com.idofast.admin.service.SystemPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/5 11:12 上午
 */
@Component
public class SystemPreferenceManager
{

    @Autowired
    private SystemPreferenceService preferenceService;

    /**
     * 获取流量重置天数
     * @return
     */
    public Integer getResetPeriod()
    {
        String resetPeriod = preferenceService.getPreference(SystemPreferenceEnum.DATA_RESET_PERIOD);
        return Integer.parseInt(resetPeriod);
    }


    /**
     * 获取新注册用户免费使用时长，单位：分钟
     * @return
     */
    public Integer getFreeUseTime()
    {
        String preference = preferenceService.getPreference(SystemPreferenceEnum.FREE_USER_TIME);
        return Integer.parseInt(preference);
    }



}
