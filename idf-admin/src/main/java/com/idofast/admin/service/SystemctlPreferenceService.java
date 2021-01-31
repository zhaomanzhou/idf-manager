package com.idofast.admin.service;

import com.idofast.admin.constant.SystemPreferenceConst;
import com.idofast.admin.domain.SystemPreference;
import com.idofast.admin.repository.SystemPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 10:07 下午
 */
@Service
public class SystemctlPreferenceService
{

    @Autowired
    private SystemPreferenceRepository systemPreferenceRepository;


    /**
     * 获取流量重置天数
     * @return
     */
    public Integer getPreferenceResetPeriod()
    {
        SystemPreference preference = new SystemPreference();
        preference.setPreKey(SystemPreferenceConst.DATA_RESET_PERIOD);
        Example<SystemPreference> example = Example.of(preference);
        Optional<SystemPreference> one = systemPreferenceRepository.findOne(example);
        return one.map(systemPreference -> Integer.parseInt(systemPreference.getPreValue())).orElse(SystemPreferenceConst.DEFAULT_DATA_RESET_PERIOD);
    }
}
