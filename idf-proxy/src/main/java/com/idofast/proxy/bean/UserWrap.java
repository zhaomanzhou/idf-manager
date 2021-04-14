package com.idofast.proxy.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/14 12:43 上午
 */
@Data
@Slf4j
public class UserWrap
{
    private Long id;

    private LocalDateTime lastUpdatedTime;
    private LocalDateTime lastReportedTime;

    private AtomicLong usedDate;
    private AtomicInteger connectionNum;



    public void addData(Long used)
    {
        this.usedDate.addAndGet(used);
        this.lastUpdatedTime = LocalDateTime.now();
    }

    public int addConnectionNum()
    {
        int i = connectionNum.incrementAndGet();
        this.lastUpdatedTime = LocalDateTime.now();
        return i;
    }

    public int decrementConnectionNum()
    {
        int i = connectionNum.decrementAndGet();
        this.lastUpdatedTime = LocalDateTime.now();
        if(i < 0)
        {
            log.warn("负的连接数");
        }
        return i;
    }



    public static UserWrap defaultUserWrap(Long id)
    {
        UserWrap user = new UserWrap();
        user.setId(id);
        user.setLastUpdatedTime(LocalDateTime.now());
        user.setUsedDate(new AtomicLong(0));
        user.setConnectionNum(new AtomicInteger(0));
        user.setLastReportedTime(LocalDateTime.now());
        user.setLastUpdatedTime(LocalDateTime.now().plusSeconds(1L));
        return user;
    }


}
