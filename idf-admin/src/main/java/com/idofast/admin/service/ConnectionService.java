package com.idofast.admin.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.idofast.common.dto.StateMessage;
import com.idofast.common.dto.StateReportDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/15 12:46 上午
 */
@Service
public class ConnectionService
{


    //value为这台服务器上现在的人与他的连接数键值对
    final Cache<String, ConcurrentHashMap<Long, Integer>> serverCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();

    //value为这个用户 所在的服务器与他在这台服务器上的连接数简直对
    final Cache<Long, ConcurrentHashMap<String, Integer>> userCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();




    public synchronized void updateStateInfo(StateReportDto stateReportDto) throws ExecutionException
    {

        synchronized (serverCache)
        {
            //更新server cache
            ConcurrentHashMap<Long, Integer> userConnectionMap = serverCache.get(stateReportDto.getHost(), ConcurrentHashMap::new);
            for (int i = 0; i < stateReportDto.getContents().size(); i++)
            {
                StateMessage stateMessage = stateReportDto.getContents().get(i);
                if(stateMessage.getConnectionNum() > 0)
                {
                    userConnectionMap.put(stateMessage.getId(), stateMessage.getConnectionNum());
                }else
                {
                    userConnectionMap.remove(stateMessage.getId());
                }
            }
        }


       synchronized (userCache)
       {
           //更新userCache
           for(StateMessage stateMessage: stateReportDto.getContents())
           {
               //用户目前所在地所有服务器以及他的连接数
               ConcurrentHashMap<String, Integer> serverMap = userCache.get(stateMessage.getId(), ConcurrentHashMap::new);
               if(stateMessage.getConnectionNum() == 0)
               {
                   serverMap.remove(stateReportDto.getHost());
               }else
               {
                   serverMap.put(stateReportDto.getHost(), stateMessage.getConnectionNum());
               }

           }
       }

    }


    public int getConnectionNumByHost(String host)
    {

        ConcurrentHashMap<Long, Integer> ifPresent = serverCache.getIfPresent(host);
        if(ifPresent == null)
        {
            return 0;
        }
        int num = ifPresent.values().stream().reduce(0, Integer::sum);
        return num;
    }



    public ConcurrentMap<String, ConcurrentHashMap<Long, Integer>> getServerCache()
    {
        return serverCache.asMap();
    }

    public Cache<Long, ConcurrentHashMap<String, Integer>> getUserCache()
    {
        return userCache;
    }
}
