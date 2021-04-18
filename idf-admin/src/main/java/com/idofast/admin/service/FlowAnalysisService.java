package com.idofast.admin.service;

import com.idofast.admin.controller.vo.response.DashBoradDataLog;
import com.idofast.admin.util.LockPoolUtil;
import com.idofast.common.dto.StateMessage;
import com.idofast.common.dto.StateReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/18 12:55 上午
 *
 *
 * hash  hashKey  FlowOfDay-id-yyyy-mm
 *                 key  mm-dd
 */
@Service
public class FlowAnalysisService
{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String keyPrefix = "FlowOfDay-";


    public void update(StateReportDto stateReportDto )
    {
        Random r = new Random();
        for (int i = 0; i < 70; i++)
        {
            LocalDateTime now = LocalDateTime.now().plusDays(i*-1 + 20);
            String hashName = now.format(DateTimeFormatter.ofPattern("-yyyy-MM"));
            String key = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            for (StateMessage stateMessage : stateReportDto.getContents())
            {
                Object o = redisTemplate.opsForHash().get(keyPrefix + stateMessage.getId() + hashName, key);
                Long sum = 0L;
                if (o != null)
                {
                    sum = Long.parseLong(o.toString()) + r.nextInt(1024*1024);
                }
                sum += stateMessage.getUsedDate();
                redisTemplate.opsForHash().put(keyPrefix + stateMessage.getId() + hashName, key, sum);

            }
        }
    }


    public void updateFlowInfo(StateReportDto stateReportDto )
    {
        LocalDateTime now = LocalDateTime.now().plusDays(13);
        String hashName = now.format(DateTimeFormatter.ofPattern("-yyyy-MM"));
        String key = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for(StateMessage stateMessage: stateReportDto.getContents())
        {
            synchronized (LockPoolUtil.getWeakReference(stateMessage.getId()))
            {
                Object o = redisTemplate.opsForHash().get(keyPrefix + stateMessage.getId() + hashName , key);
                Long sum = 0L;
                if(o != null)
                {
                    sum = Long.parseLong(o.toString());
                }
                sum += stateMessage.getUsedDate();
                redisTemplate.opsForHash().put(keyPrefix + stateMessage.getId() + hashName, key, sum);
                redisTemplate.expire(keyPrefix + stateMessage.getId() + hashName, 60, TimeUnit.DAYS);
            }

        }
    }

    /**
     * 获取某个用户的流量记录
     * @param id 用户id
     * @return
     */
    public List<DashBoradDataLog> getFlowData(Long id)
    {
        LocalDateTime now = LocalDateTime.now();
        String hashName = now.format(DateTimeFormatter.ofPattern("-yyyy-MM"));
        Map<Object, Object> entries1 = redisTemplate.opsForHash().entries(keyPrefix + id + hashName);
        //上一个月的
        now = now.plusMonths(-1);
        hashName = now.format(DateTimeFormatter.ofPattern("-yyyy-MM"));
        Map<Object, Object> entries2 = redisTemplate.opsForHash().entries(keyPrefix + id + hashName);


        now = now.plusMonths(1).plusDays(-30);
        List<DashBoradDataLog> list = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            now = now.plusDays(1);
            String key = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Object o = entries2.get(key);
            if(o != null)
            {
                list.add(new DashBoradDataLog(key, ((Integer)o)/1024));
                continue;
            }
            o = entries1.get(key);
            if(o != null)
            {
                list.add(new DashBoradDataLog(key, ((Integer)o)/1024));

                continue;
            }
            list.add(new DashBoradDataLog(key, 0));

        }


        return list;

    }






}
