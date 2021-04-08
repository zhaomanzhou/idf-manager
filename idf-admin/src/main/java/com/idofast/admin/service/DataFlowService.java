package com.idofast.admin.service;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 7:43 下午
 */

import com.idofast.admin.domain.DataResetLog;
import com.idofast.admin.repository.DataResetLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataFlowService
{
    @Autowired
    private DataResetLogRepository dataResetLogRepository;


    public List<DataResetLog> findAllByUserId(Long userId)
    {
        return dataResetLogRepository.findAllByUserId(userId);
    }
}
