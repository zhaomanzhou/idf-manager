package com.idofast.proxy.framework.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.error.BusinessException;
import com.idofast.common.util.LocalDateTimeUtil;
import com.idofast.proxy.service.V2rayService;
import com.idofast.proxy.web.adapter.ProxyAccountAdapt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
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
    private Cache<Long, String> errorCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(1000L).build();


    Interner<String> pool = Interners.newWeakInterner();


    /**
     * 获取不到用户，抛异常
     * 获取到用户(即使为空)返回
     * @param id
     * @return
     * @throws BusinessException
     */
    public V2rayAccountDto getAndSynchUserById(Long id) throws BusinessException
    {

        synchronized (pool.intern(id+""))
        {
            if(accountMap.containsKey(id))
            {
                V2rayAccountDto accountDto = accountMap.get(id);
                checkUserValid(accountDto);
                return accountDto;
            }


            String reason = errorCache.getIfPresent(id);
            if(!StringUtils.isEmpty(reason))
            {
                throw new BusinessException(reason);
            }


            int retryTime = 2;
            while (true)
            {
                try
                {
                    V2rayAccountDto accountDto = accountAdapt.getRemoteV2rayAccountDto(id);
                    //远程没有用户
                    if(accountDto == null)
                    {
                        log.warn("远程获取到空的用户，id：{}", id);
                        errorCache.put(id, "用户不存在, id:" + id);
                        throw new BusinessException(errorCache.getIfPresent(id));
                    }
                    System.out.println(accountDto);
                    accountMap.put(id, accountDto);
                    break;
                } catch (Exception e)
                {
                    if(errorCache.getIfPresent(id) != null)
                    {
                        throw e;
                    }

                    if(retryTime > 0)
                    {
                        log.warn("请求失败，开始重试, 还有{}次机会, 错误信息为:{}", retryTime, e.getMessage());
                        retryTime--;
                    }else
                    {
                        log.warn("请求失败，没有重试机会，返回空");
                        errorCache.put(id, "超过最大远端请求失败重试次数，id:" + id );
                        throw new BusinessException(errorCache.getIfPresent(id));
                    }
                }
            }


            V2rayAccountDto accountDto = accountMap.get(id);
            try
            {
                checkUserValid(accountDto);
            } catch (Exception e)
            {
                errorCache.put(id, e.getMessage());
                accountMap.remove(id);
                throw e;
            }

            try
            {
                v2rayService.addProxyAccount(v2rayHost, v2rayPort, tag, accountDto);
            } catch (Exception e)
            {
                e.printStackTrace();
                log.error("grpc调用添加用户失败 {}", e.getMessage());
            }
            return accountDto;
        }

    }

    private void checkUserValid(V2rayAccountDto accountDto) throws BusinessException
    {
        if(LocalDateTimeUtil.toLocalDateTime(accountDto.getExpireDate()).isBefore(LocalDateTime.now()))
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
