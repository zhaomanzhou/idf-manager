package com.idofast.admin.service;

import com.idofast.admin.domain.SystemPreference;
import com.idofast.admin.domain.enums.SystemPreferenceEnum;
import com.idofast.admin.repository.SystemPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
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




//    @Cacheable(value = "preference-cache",key = ("#keyEnum.key"))
    public String getPreference(SystemPreferenceEnum keyEnum)
    {
        SystemPreference preference = new SystemPreference();
        preference.setPreKey(keyEnum.getKey());
        Example<SystemPreference> example = Example.of(preference);
        Optional<SystemPreference> one = systemPreferenceRepository.findOne(example);
        return one.isPresent()? one.get().getPreValue(): keyEnum.getDefaultValue();
    }

//    @CachePut(value = "preference-cache",key = ("#keyEnum.key"))
    public void updatePreference(SystemPreferenceEnum keyEnum, String value)
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


    public List<SystemPreference> getAllPreference()
    {
        List<SystemPreference> all = systemPreferenceRepository.findAll();
        return all;
    }

    public List<SystemPreference> getAllInstruction()
    {
        return systemPreferenceRepository.findAllByPreKeyLike("INSTRUCTION_LINK%");
    }


}
