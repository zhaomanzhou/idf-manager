package com.idofast.proxy.biz.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.idofast.common.common.Result;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.exception.BusinessException;
import com.idofast.common.retry.RetryCommand;
import com.idofast.common.retry.RetryUtil;
import com.idofast.common.util.LocalDateTimeUtil;
import com.idofast.common.util.LockUtil;
import com.idofast.proxy.biz.adapter.ProxyAccountAdapt;
import com.idofast.proxy.service.V2rayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 5:43 下午
 */
@Component
@Slf4j
public class AccountService
{

    @Autowired
    private ProxyAccountAdapt accountAdapt;

    @Autowired
    private V2rayService v2rayService;


    @Autowired
    private ExecutorService v2rayGrpcAddPool;


    private ConcurrentHashMap<Long, V2rayAccountDto> accountMap = new ConcurrentHashMap<>();

    @Value("${proxy.v2ray.host}")
    private String v2rayHost;

    @Value("${proxy.v2ray.apiPort}")
    private Integer v2rayPort;

    @Value("${proxy.v2ray.tag}")
    private String tag;
    /**
     * 最多重试三次
     * value为错误原因
     */
    private Cache<Long, String> errorCache = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(1000L).build();





    /**
     * 获取不到用户，抛异常
     * 获取到用户(即使为空)返回
     * @param id
     * @return
     * @throws BusinessException
     */
    public V2rayAccountDto getAndSynchUserById(Long id) throws BusinessException
    {

        synchronized (LockUtil.getStringLock(id+""))
        {
            String reason = errorCache.getIfPresent(id);
            if(!StringUtils.isEmpty(reason))
            {
                throw new BusinessException(reason);
            }


            V2rayAccountDto accountDto = null;
            if(!accountMap.containsKey(id))
            {
                final RetryCommand<V2rayAccountDto> retryCommand = RetryCommand.<V2rayAccountDto>builder()
                        .command(() -> accountAdapt.getRemoteV2rayAccountDto(id))
                        .retryTime(3)
                        .delayTime(-1L)
                        .name("获取远程V2ray账户")
                        .build();
                final Result<V2rayAccountDto> result = RetryUtil.syncRetry(retryCommand);
                if(!result.isSuccess()){
                    errorCache.put(id, "超过最大远端请求失败重试次数，id:" + id );
                    throw new BusinessException(errorCache.getIfPresent(id));
                }
                accountDto = result.getData();
                if(accountDto == null)
                {
                    log.warn("远程获取到空的用户，id：{}", id);
                    errorCache.put(id, "用户不存在, id:" + id);
                    throw new BusinessException(errorCache.getIfPresent(id));
                }

                accountMap.put(id, accountDto);
            }else
            {
                accountDto = accountMap.get(id);
            }


            try
            {
                checkUserValid(accountDto);
            } catch (Exception e)
            {
                errorCache.put(id, e.getMessage());
                accountMap.remove(id);
                throw e;
            }


            V2rayAccountDto finalAccountDto = accountDto;
            v2rayGrpcAddPool.submit(() -> {
                try
                {
                    v2rayService.addProxyAccount(v2rayHost, v2rayPort, tag, finalAccountDto);
                } catch (Exception e)
                {
                    e.printStackTrace();
                    log.error("grpc调用添加用户失败 {}", e.getMessage());
                }
            });

            return accountDto;
        }

    }






    private void checkUserValid(V2rayAccountDto accountDto) throws BusinessException
    {
        if(accountDto.getExpireDate() < LocalDateTimeUtil.toTimeStamp(LocalDateTime.now()))
        {
            throw new BusinessException("用户已过期, id:" + accountDto.getId());
        }
        if(accountDto.getAvailableData() <= 0)
        {
            throw new BusinessException("用户流量已用完, id:" + accountDto.getId());
        }

        if(!accountDto.getEnable())
        {
            throw new BusinessException("用户已封禁，id:" + accountDto.getId());
        }
    }



    public void invalidUser(Long id)
    {
        accountMap.remove(id);
        errorCache.put(id, "master端告诉我账号失效");
    }
}
