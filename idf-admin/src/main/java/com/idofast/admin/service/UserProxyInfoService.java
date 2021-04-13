package com.idofast.admin.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.idofast.admin.controller.vo.request.ProxyInfoUpdateVo;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.dto.UserInfoLite;
import com.idofast.admin.event.event.UserRegisterEvent;
import com.idofast.admin.event.publisher.EventPublisher;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.common.util.LocalDateTimeUtil;
import com.idofast.common.response.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 12:32 上午
 */
@Service
@Slf4j
public class UserProxyInfoService
{
    @Autowired
    private UserProxyInfoRepository userProxyInfoRepository;

    @Autowired
    private EventPublisher eventPublisher;


    /**
     * 根据Id获取用户信息，如果不存在则新创建
     * @param id 用户的id
     * @param ifCreate 如果不存在是否新建
     */
    public UserProxyInfo selectById(Long id, boolean ifCreate) throws BusinessException
    {
        Optional<UserProxyInfo> byId = userProxyInfoRepository.findById(id);

        //TODO  报警
        if(byId.isEmpty())
        {
            log.error("用户{}没有生成相应的UserProxy代理信息", id);
            if(ifCreate)
            {
                eventPublisher.publishEvent(new UserRegisterEvent(this, id));
               return userProxyInfoRepository.findById(id).get();
            }else
            {
                throw new BusinessException("用户信息不存在");
            }

        }else
        {
            return byId.get();
        }
    }


    public Page<UserInfoLite> getUserList(Pageable page)
    {
        return userProxyInfoRepository.queryUserInfo(page);
    }


    public void updateUserProxyInfo(ProxyInfoUpdateVo updateVo) throws BusinessException
    {


        Optional<UserProxyInfo> proxyInfoHolder = userProxyInfoRepository.findById(updateVo.getId());
        if(proxyInfoHolder.isEmpty()){
            throw new BusinessException("用户不存在");
        }
        UserProxyInfo proxyInfo = proxyInfoHolder.get();
        BeanUtil.copyProperties(updateVo, proxyInfo,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        proxyInfo.setExpireDate(LocalDateTimeUtil.toLocalDateTime(updateVo.getExpireDate()));
        proxyInfo.setNextSettleDate(LocalDateTimeUtil.toLocalDateTime(updateVo.getNextSettleDate()));

        userProxyInfoRepository.save(proxyInfo);

    }



}
