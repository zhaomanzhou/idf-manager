package com.idofast.admin.task;

import com.idofast.admin.domain.Bundle;
import com.idofast.admin.domain.DataResetLog;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.repository.DataResetLogRepository;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.admin.service.BundleService;
import com.idofast.common.response.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 6:27 下午
 */
@Component
@Slf4j
public class ResetDataTask
{

    @Autowired
    private UserProxyInfoRepository proxyInfoRepository;

    @Autowired
    private DataResetLogRepository dataResetLogRepository;

    @Autowired
    private BundleService bundleService;

    @Scheduled(cron = "0 0 0/3  * * ?")
    public void resetData() throws BusinessException
    {

        log.info("-------------------开始进行流量重置定时任务--------------------------");

        List<UserProxyInfo> proxyInfoList = proxyInfoRepository.findAllByNextSettleDateBeforeAndAndExpireDateAfter(LocalDateTime.now(), LocalDateTime.now());

        for (UserProxyInfo proxyInfo: proxyInfoList)
        {
            log.info("用户{}，本周期使用流量{}，已重置", proxyInfo.getId(), proxyInfo.getUsedData());

            Bundle bundle = bundleService.findById(proxyInfo.getBundleId());
            DataResetLog dataResetLog = DataResetLog.builder()
                    .userId(proxyInfo.getId())
                    .endDate(proxyInfo.getNextSettleDate())
                    .startDate(proxyInfo.getNextSettleDate().plusDays(-1 * bundle.getDuration()))
                    .usedData(proxyInfo.getUsedData())
                    .build();

            proxyInfo.setNextSettleDate(proxyInfo.getNextSettleDate().plusDays(bundle.getDuration()));
            proxyInfo.setUsedData(0L);

            proxyInfoRepository.save(proxyInfo);
            dataResetLogRepository.save(dataResetLog);
        }
        log.info("-----------------------流量重置定时任务结束--------------------------");

    }
}
