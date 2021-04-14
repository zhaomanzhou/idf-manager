package com.idofast.common.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/14 2:15 下午
 */
@Data
public class StateReportDto
{
    @NotNull
    private List<StateMessage> contents;

    @NotNull
    private String host;
}
