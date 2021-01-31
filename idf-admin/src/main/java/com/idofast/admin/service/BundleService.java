package com.idofast.admin.service;

import com.idofast.admin.domain.Bundle;
import com.idofast.admin.repository.BundleRepository;
import com.idofast.common.response.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/1/25 9:45 下午
 */

@Service
public class BundleService
{
    @Autowired
    private BundleRepository bundleRepository;



    public void addBundle(Bundle bundle)
    {
        bundle.setId(null);
        bundle.setCreateTime(null);
        bundle.setUpdateTime(null);
        if(bundle.getActive() == null){
            bundle.setActive(true);
        }
        bundleRepository.save(bundle);
    }

    /**
     * 获取套餐列表
     * @param filterDown  是否过滤掉下架的套餐
     */
    public List<Bundle> getAllPackageBundles(boolean filterDown)
    {
        Bundle bundle = new Bundle();
        if(filterDown)
        {
            bundle.setActive(true);
        }
        Example<Bundle> of = Example.of(bundle);
        return bundleRepository.findAll(of);
    }


    public Bundle findById(Long id) throws BusinessException
    {
        Optional<Bundle> byId = bundleRepository.findById(id);
        if(byId.isEmpty())
        {
            throw new BusinessException("该套餐不存在");
        }
        return byId.get();
    }

    public void updateBundle(Bundle bundle)
    {
        bundle.setCreateTime(null);
        bundle.setUpdateTime(null);
        bundleRepository.save(bundle);
    }

    public void deleteBundle(Long id)
    {
        bundleRepository.deleteById(id);
    }


}
