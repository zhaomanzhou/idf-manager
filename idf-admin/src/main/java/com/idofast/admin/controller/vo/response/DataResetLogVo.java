package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.DataResetLog;
import com.idofast.admin.util.LocalDateTimeUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 7:54 下午
 */
@Data
public class DataResetLogVo
{
    private Long id;


    private Long createTime;


    private Long updateTime;

    private Long userId;

    private Long startDate;

    private Long endDate;

    private Long usedData;

    public static DataResetLogVo convertToVo(DataResetLog log)
    {
        DataResetLogVo vo = new DataResetLogVo();
        BeanUtils.copyProperties(log, vo);
        vo.setCreateTime(LocalDateTimeUtil.toTimeStamp(log.getCreateTime()));
        vo.setUpdateTime(LocalDateTimeUtil.toTimeStamp(log.getUpdateTime()));
        vo.setStartDate(LocalDateTimeUtil.toTimeStamp(log.getStartDate()));
        vo.setEndDate(LocalDateTimeUtil.toTimeStamp(log.getEndDate()));
        return vo;
    }
}
