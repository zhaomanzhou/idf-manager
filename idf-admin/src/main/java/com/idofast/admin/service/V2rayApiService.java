package com.idofast.admin.service;

import com.idofast.admin.controller.vo.response.DirectV2rayNodeVo;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.dto.V2rayAccount;
import com.idofast.admin.infrastructure.ProxyApiAdapter;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.common.dto.StateMessage;
import com.idofast.common.dto.StateReportDto;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.enums.UserStatusEnum;
import com.idofast.common.response.exception.BusinessException;
import com.idofast.common.util.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:29 下午
 */
@Service
@Slf4j
public class V2rayApiService
{

    @Autowired
    private UserProxyInfoRepository proxyInfoRepository;

    @Autowired
    private ProxyApiAdapter proxyApiAdapter;

    @Autowired
    private NodeService nodeService;




    public V2rayAccountDto queryById(Long id) throws BusinessException
    {
        if(ObjectUtils.isEmpty(id))
        {
            throw new BusinessException("id不能为空");
        }
        Optional<V2rayAccount> v2rayAccountOptional = proxyInfoRepository.queryAccount(id);
        if(v2rayAccountOptional.isEmpty())
        {
            return null;
        }
        V2rayAccount v2rayAccount = v2rayAccountOptional.get();
        V2rayAccountDto dto = new V2rayAccountDto();
        BeanUtils.copyProperties(v2rayAccount, dto);
        dto.setExpireDate(LocalDateTimeUtil.toTimeStamp(v2rayAccount.getExpireDate()));
        dto.setAvailableData(v2rayAccount.getTotalDate() - v2rayAccount.getUserData());
        dto.setEnable(v2rayAccount.getStatus() == UserStatusEnum.NORMAL);
        return dto;
    }



    public void updateUseState(StateReportDto stateReportDto)
    {
        for(StateMessage stateMessage: stateReportDto.getContents())
        {
            Optional<UserProxyInfo> byId = proxyInfoRepository.findById(stateMessage.getId());
            if(byId.isPresent())
            {
                UserProxyInfo proxyInfo = byId.get();
                proxyInfo.setUsedData(proxyInfo.getUsedData() + stateMessage.getUsedDate());
                proxyInfoRepository.save(proxyInfo);
                if(proxyInfo.getExpireDate().isBefore(LocalDateTime.now()) || proxyInfo.getTotalData() - proxyInfo.getUsedData()  <= 0)
                {
                    //用户已过期，过期处理
                    rmRemoteAccount(proxyInfo.getId());
                }
            }
        }
    }

    public void rmRemoteAccount(Long id)
    {

        List<DirectV2rayNodeVo> allDirectNodes = nodeService.getAllDirectNodes();
        log.info("开始向所有远端服务器删除用户{}, 一共{}个服务器", id, allDirectNodes.size());
        for(DirectV2rayNodeVo node: allDirectNodes)
        {
            int retryTime = 3;
            while (retryTime > 0)
            {
                log.info("开始第{}次向远程服务器提交删除账号请求，id:{}, host:{}", 4-retryTime, id, node.getHost());

                retryTime--;
                try
                {
                    proxyApiAdapter.rmAccount(id, node.getHost());
                    log.info("删除成功");
                    break;
                } catch (Exception e)
                {
                    log.info("删除失败，{}", e.getMessage());
                }
            }
        }

    }



}
