package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.controller.vo.response.DataResetLogVo;
import com.idofast.admin.domain.DataResetLog;
import com.idofast.admin.service.DataFlowService;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 7:38 下午
 */
@RestController
@RequestMapping("/data")
@Api(tags = "流量相关的api")
@CrossOrigin
@Slf4j
public class DataFlowController
{
    @Autowired
    private DataFlowService dataFlowService;

    @GetMapping("/resetlog")
    @AuthRole(RoleEnum.ADMIN)
    @ApiOperation("获取用户的流量使用记录")
    public ServerResponse<List<DataResetLogVo>> getDataResetLogByUserId(@NotNull Long userId)
    {
        List<DataResetLog> allByUserId = dataFlowService.findAllByUserId(userId);

        List<DataResetLogVo> collect = allByUserId.stream()
                .map(DataResetLogVo::convertToVo)
                .collect(Collectors.toList());
        return ServerResponse.success(collect);
    }
}
