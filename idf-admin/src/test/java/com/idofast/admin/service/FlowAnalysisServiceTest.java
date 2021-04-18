package com.idofast.admin.service;

import com.google.common.collect.Lists;
import com.idofast.common.dto.StateMessage;
import com.idofast.common.dto.StateReportDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/18 11:21 上午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FlowAnalysisServiceTest
{

    @Autowired
    private FlowAnalysisService flowAnalysisService;

    @Test
    public void getFlowData()
    {
//        TreeMap<Object, Object> flowData = flowAnalysisService.getFlowData(1L);
//
//        for(Map.Entry entry: flowData.entrySet())
//        {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        System.out.println(LocalDateTime.now());
    }


    @Test
    public void updateFlowInfo()
    {
        StateReportDto dto = new StateReportDto();
        dto.setHost("hk.zmz121.cn");
        StateMessage stateMessage = new StateMessage();
        stateMessage.setId(12233L);
        stateMessage.setUsedDate(1024*1024*10L);
        dto.setContents(Lists.asList(stateMessage, new StateMessage[0]));
//        flowAnalysisService.updateFlowInfo(dto);
        flowAnalysisService.update(dto);
    }
}