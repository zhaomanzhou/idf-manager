package com.idofast.proxy.framework.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.util.LocalDateTimeUtil;
import com.idofast.proxy.service.V2rayService;
import com.idofast.proxy.web.adapter.ProxyAccountAdapt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    /**
     * 最多重试三次
     * value严格来说无意义，只是站位用
     */
    Cache<Long, Integer> retryTimeCache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.MINUTES).maximumSize(1000L).build();


    Interner<String> pool = Interners.newWeakInterner();


    public V2rayAccountDto getAndSynchUserById(Long id)
    {

        synchronized (pool.intern(id+""))
        {
            if(accountMap.containsKey(id))
            {
                V2rayAccountDto accountDto = accountMap.get(id);
                checkUserValid(accountDto);
                return accountDto;
            }


            Integer retryTime = retryTimeCache.getIfPresent(id);
            if(retryTime == null)
            {
                retryTimeCache.put(id, 2);
                retryTime = 2;
            }
            //之前有过错误的重试，且在一分钟之内
            else
            {
                return null;
            }


            while (true)
            {
                try
                {
                    V2rayAccountDto accountDto = accountAdapt.getRemoteV2rayAccountDto(id);
                    //远程没有用户
                    if(accountDto == null)
                    {
                        retryTimeCache.put(id, 2);
                        log.warn("远程获取不到该用户，id：{}", id);
                        return null;
                    }
                    accountMap.put(id, accountDto);
                    break;
                } catch (Exception e)
                {
                    if(retryTime > 0)
                    {
                        log.warn("请求失败，开始重试, 还有{}次机会, 错误信息为{}", retryTime, e.getMessage());
                        retryTime--;
                    }else
                    {
                        log.warn("请求失败，没有重试机会，返回空");
                        return null;
                    }
                }
            }

            V2rayAccountDto accountDto = accountMap.get(id);
            checkUserValid(accountDto);

            try
            {
//                v2rayService.addProxyAccount(v2rayHost, v2rayPort, accountDto);
            } catch (Exception e)
            {
                e.printStackTrace();
                log.warn("grpc调用添加用户失败 {}", e.getMessage());
            }
            return accountDto;
        }

    }

    private void checkUserValid(V2rayAccountDto accountDto)
    {
        if(LocalDateTimeUtil.toLocalDateTime(accountDto.getExpireDate()).isBefore(LocalDateTime.now()))
        {
            throw new RuntimeException("用户已过期");
        }
        if(accountDto.getAvailableData() <= 0)
        {
            throw new RuntimeException("用户流量已用完");
        }
    }
}
