package com.idofast.admin.service;

import com.idofast.admin.domain.dto.OnlineUserDto;
import com.idofast.common.dto.StateMessage;
import com.idofast.common.dto.StateReportDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/15 12:46 上午
 */
@Service
public class ConnectionService
{

    private ConcurrentHashMap<String, List<OnlineUserDto>> serverBasedMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<OnlineUserDto, List<String>> userBasedMap = new ConcurrentHashMap<>();



    public void updateStateInfo(StateReportDto stateReportDto)
    {
        List<OnlineUserDto> onlineUserDtos= serverBasedMap.computeIfAbsent(stateReportDto.getHost(), s -> new ArrayList<>());
        List<StateMessage> contents = stateReportDto.getContents();
        for(StateMessage stateMessage: contents)
        {

            for(OnlineUserDto oonlineUserDto : onlineUserDtos)
            {
                if(oonlineUserDto.getId().equals(stateMessage.getId()))
                {
                    oonlineUserDto.setConnectionNum(stateMessage.getConnectionNum());
                    continue;
                }
            }

            //没有，新建
        }

    }
}
