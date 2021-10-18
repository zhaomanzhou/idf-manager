package com.idofast.proxy.biz.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.idofast.common.dto.StateMessage;
import com.idofast.proxy.common.bean.UserWrap;
import com.idofast.proxy.biz.adapter.ProxyAccountAdapt;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/14 12:46 上午
 */
@Service
@Slf4j
public class UserReportService
{

    @Autowired
    private ProxyAccountAdapt proxyAccountAdapt;

    private final ScheduledExecutorService schedulePool =
            Executors.newScheduledThreadPool(1, new DefaultThreadFactory("report-state"));

    private final ConcurrentHashMap<Long, UserWrap> userSateMap = new ConcurrentHashMap<>();


    public void addUsedData(Long userId, Long dataUsed)
    {
        UserWrap userWrap = userSateMap.computeIfAbsent(userId, UserWrap::defaultUserWrap);
        userWrap.addData(dataUsed);
    }

    public int addConnectionNum(Long userId)
    {
        UserWrap userWrap = userSateMap.computeIfAbsent(userId, UserWrap::defaultUserWrap);
        return userWrap.addConnectionNum();

    }

    public int decreaseConnectionNum(Long userId)
    {
        UserWrap userWrap = userSateMap.computeIfAbsent(userId, UserWrap::defaultUserWrap);
        return userWrap.decrementConnectionNum();

    }




    @PostConstruct
    public void schedule()
    {
        schedulePool.scheduleWithFixedDelay(new ReportJob(), 20, 3*60, TimeUnit.SECONDS);
    }


    @PreDestroy
    public void close()
    {
        schedulePool.shutdown();
    }

    class ReportJob implements Runnable
    {

        @Override
        public void run()
        {

            //要上报的用户和上报的流量， 防止上报失败流量记录丢失
            Map<UserWrap, Long> wrapToReport = Maps.newHashMap();
            List<StateMessage> stateMessageToReport = Lists.newArrayList();
            LocalDateTime now = LocalDateTime.now();
            for(Map.Entry<Long, UserWrap> entry : UserReportService.this.userSateMap.entrySet())
            {
                UserWrap userWrap = entry.getValue();
                //一个周期内没有变化，不上报
                if(userWrap.getLastReportedTime().isAfter(userWrap.getLastUpdatedTime()))
                {
                    //判断是否一个小时没有更新
                    if(userWrap.getLastUpdatedTime().plusHours(1).isBefore(now) )
                    {
                        UserReportService.this.userSateMap.remove(entry.getKey());
                    }
                }
                //上报
                else
                {
                    StateMessage stateMessage = new StateMessage();
                    stateMessage.setId(userWrap.getId());
                    stateMessage.setConnectionNum(userWrap.getConnectionNum().get());
                    stateMessage.setUsedDate(userWrap.getUsedDate().getAndSet(0L));
                    stateMessageToReport.add(stateMessage);
                    wrapToReport.put(userWrap, stateMessage.getUsedDate());
                }
            }

            //没有东西要上报
            if(stateMessageToReport.size() <= 0)
            {
                return;
            }
            log.info("开始向服务器上报用户状态: {}", stateMessageToReport);

            int retryTime = 3;
            while (retryTime > 0)
            {
                retryTime--;
                if(proxyAccountAdapt.reportUserState(stateMessageToReport))
                {
                    log.info("上报成功");
                    for(UserWrap userWrap :wrapToReport.keySet())
                    {
                        userWrap.setLastReportedTime(now);
                        return;
                    }
                    break;
                }else
                {
                    log.warn("上报失败，开始第{}次重试", 3 - retryTime);
                }
            }

            //上报失败，把流量补回来
            for(UserWrap userWrap :wrapToReport.keySet())
            {
                userWrap.addData(wrapToReport.get(userWrap));
                return;
            }
        }







    }


}
