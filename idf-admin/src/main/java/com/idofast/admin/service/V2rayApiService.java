package com.idofast.admin.service;

import com.idofast.admin.domain.dto.V2rayAccount;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.error.BusinessException;
import com.idofast.common.util.LocalDateTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:29 下午
 */
@Service
public class V2rayApiService
{

    @Autowired
    private UserProxyInfoRepository proxyInfoRepository;

    public V2rayAccountDto queryById(Long id) throws BusinessException
    {
        if(ObjectUtils.isEmpty(id))
        {
            throw new BusinessException("id不能为空");
        }
        Optional<V2rayAccount> v2rayAccountOptional = proxyInfoRepository.queryAccount(id);
        if(v2rayAccountOptional.isEmpty())
        {
            throw new BusinessException("用户不存在");
        }
        V2rayAccount v2rayAccount = v2rayAccountOptional.get();
        V2rayAccountDto dto = new V2rayAccountDto();
        BeanUtils.copyProperties(v2rayAccount, dto);
        dto.setExpireDate(LocalDateTimeUtil.toTimeStamp(v2rayAccount.getExpireDate()));
        dto.setAvailableData(v2rayAccount.getTotalDate() - v2rayAccount.getUserData());
        return dto;
    }
}
