package com.idofast.admin.service;

import com.idofast.admin.domain.SystemPreference;
import com.idofast.admin.domain.enums.SystemPreferenceKeyEnum;
import com.idofast.admin.repository.SystemPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 10:07 下午
 */
@Service
public class SystemPreferenceService
{

    //  TODO  测试

    @Autowired
    private SystemPreferenceRepository systemPreferenceRepository;




    @Cacheable(value = "preference-cache",key = ("#keyEnum.key"))
    public String getPreference(SystemPreferenceKeyEnum keyEnum)
    {
        SystemPreference preference = new SystemPreference();
        preference.setPreKey(keyEnum.getKey());
        Example<SystemPreference> example = Example.of(preference);
        Optional<SystemPreference> one = systemPreferenceRepository.findOne(example);
        return one.isPresent()? one.get().getPreValue(): keyEnum.getDefaultValue();
    }

    @CachePut(value = "preference-cache",key = ("#keyEnum.key}]"))
    public void updatePreference(SystemPreferenceKeyEnum keyEnum, String value)
    {
        SystemPreference preference = new SystemPreference();
        preference.setPreKey(keyEnum.getKey());
        Example<SystemPreference> example = Example.of(preference);
        Optional<SystemPreference> one = systemPreferenceRepository.findOne(example);
        if(one.isPresent())
        {
            preference = one.get();
        }

        preference.setPreValue(value);
        systemPreferenceRepository.save(preference);
    }


}
