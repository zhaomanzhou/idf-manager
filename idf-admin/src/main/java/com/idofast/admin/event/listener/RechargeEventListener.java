package com.idofast.admin.event.listener;

import com.idofast.admin.domain.Bundle;
import com.idofast.admin.domain.RechargeLog;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.event.event.RechargeEvent;
import com.idofast.admin.repository.RechargeLogRepository;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.admin.service.BundleService;
import com.idofast.admin.service.UserProxyInfoService;
import com.idofast.common.response.error.BusinessException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 10:35 上午
 */
@Component
@Slf4j
public class RechargeEventListener implements ApplicationListener<RechargeEvent>
{

    @Autowired
    private BundleService bundleService;

    @Autowired
    private UserProxyInfoService proxyInfoService;

    @Autowired
    private UserProxyInfoRepository proxyInfoRepository;

    @Autowired
    private RechargeLogRepository rechargeLogRepository;

    @SneakyThrows
    @Override
    public void onApplicationEvent(RechargeEvent event)
    {
        Long bundleId = event.getBundleId();
        Bundle bundle = bundleService.findById(bundleId);
        Long userId = event.getUserId();
        UserProxyInfo proxyInfo = proxyInfoService.selectById(userId, true);




        RechargeLog rechargeLog = RechargeLog.builder()
                .bundleId(bundleId)
                .bundleName(bundle.getName())
                .humanRecharge(event.getHumanRecharge())
                .duration(bundle.getDuration())
                .orderId(event.getOrderId())
                .prevBundleId(proxyInfo.getBundleId())
                .prevBundleName(proxyInfo.getBundleName())
                .prevExpireDate(proxyInfo.getExpireDate())
                .rechargeNum(event.getPeriod())
                .userId(event.getUserId())
                .build();

        //防止重复充值
        if(!event.getHumanRecharge())
        {
            if(rechargeLogRepository.findByOrderId(event.getOrderId()).isPresent())
            {
                log.warn("收到重复的充值事件");
                return;
            }
        }


        //已经过期了算，从今天开始计算
        int totalDay = event.getPeriod() * bundle.getDuration();

        //初始充值  不用管human和自动充值
        if(proxyInfo.getBundleId().equals(0L))
        {



            proxyInfo.setExpireDate(LocalDateTime.now().plusDays(totalDay));
            proxyInfo.setNextSettleDate(LocalDateTime.now().plusDays(bundle.getDuration()));
            proxyInfo.setBundleId(bundleId);
            proxyInfo.setBundleName(bundle.getName());
            proxyInfo.setLevel(bundle.getLevel());
            proxyInfo.setSpeed(bundle.getSpeed());
            proxyInfo.setTotalActiveDay(totalDay);
            proxyInfo.setMaxConnection(proxyInfo.getMaxConnection());
            proxyInfo.setTotalData(bundle.getTotalData());
            proxyInfo.setUsedData(0);
            proxyInfoRepository.save(proxyInfo);
            saveRechargeLog(rechargeLog);
            return;
        }





        if(proxyInfo.getExpireDate().isBefore(LocalDateTime.now()))
        {
            proxyInfo.setExpireDate(LocalDateTime.now().plusDays(totalDay));
            proxyInfo.setNextSettleDate(LocalDateTime.now().plusDays(bundle.getDuration()));
        }else
        {
            proxyInfo.setExpireDate(proxyInfo.getExpireDate().plusDays(totalDay));
        }

        //扫码支付的，这里也要校验
        if(!event.getHumanRecharge())
        {
            //异常支付
            if(!proxyInfo.getBundleId().equals(bundleId) && proxyInfo.getExpireDate().isAfter(LocalDateTime.now()))
            {
                log.error("异常支付，用户id：{}， 充值套餐Id: {}", userId, bundleId);
                throw new BusinessException(String.format("异常支付，用户id：%d， 充值套餐Id: %d", userId, bundleId));
            }

            //正常续费
            proxyInfoRepository.save(proxyInfo);
            saveRechargeLog(rechargeLog);
            return;
        }else
        {
            //手动充值

            //正常续费
            if(proxyInfo.getBundleId().equals(bundleId))
            {
                proxyInfoRepository.save(proxyInfo);
                saveRechargeLog(rechargeLog);
                return;
            }

            //清除掉原来的套餐信息
            else
            {

                proxyInfo.setExpireDate(LocalDateTime.now().plusDays(totalDay));
                proxyInfo.setTotalData(bundle.getTotalData());
                proxyInfo.setNextSettleDate(LocalDateTime.now().plusDays(bundle.getDuration()));
                proxyInfo.setBundleId(bundleId);
                proxyInfo.setBundleName(bundle.getName());
                proxyInfo.setLevel(bundle.getLevel());
                proxyInfo.setSpeed(bundle.getSpeed());
                proxyInfo.setTotalActiveDay(totalDay);
                proxyInfo.setMaxConnection(proxyInfo.getMaxConnection());
                proxyInfo.setUsedData(0);
                saveRechargeLog(rechargeLog);
                proxyInfoRepository.save(proxyInfo);


            }





        }


    }


    private void saveRechargeLog(RechargeLog rechargeLog)
    {
        rechargeLogRepository.save(rechargeLog);
    }


}
