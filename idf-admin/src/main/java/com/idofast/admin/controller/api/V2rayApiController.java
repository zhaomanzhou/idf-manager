package com.idofast.admin.controller.api;

import com.idofast.admin.service.ConnectionService;
import com.idofast.admin.service.FlowAnalysisService;
import com.idofast.admin.service.V2rayApiService;
import com.idofast.common.dto.StateReportDto;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:11 下午
 */

@RestController
@RequestMapping("/master/api")
@Api(tags = "订单相关的api")
@CrossOrigin
@Slf4j
@Validated
public class V2rayApiController
{

   @Autowired
   private V2rayApiService v2rayApiService;

   @Autowired
   private ConnectionService connectionService;

   @Autowired
   private FlowAnalysisService flowAnalysisService;


   private ExecutorService es = new ThreadPoolExecutor(3, 10, 10, TimeUnit.MINUTES,
           new ArrayBlockingQueue<>(100), new DefaultThreadFactory("report-handler"));

   @RequestMapping("/user/detail")
   @ApiOperation("获取用户信息")
    public ServerResponse<V2rayAccountDto> getAccountById(@NonNull Long id) throws BusinessException
    {
        V2rayAccountDto v2rayAccountDto = v2rayApiService.queryById(id);
        return ServerResponse.success(v2rayAccountDto);
    }

    @PostMapping("/state/report")
    @ApiOperation("代理端流量状态上报接口")
    public ServerResponse<String> reportUserState(@RequestBody StateReportDto stateReportDto) throws BusinessException
    {
        es.submit(()->{
            v2rayApiService.updateUseState(stateReportDto);
        });
        es.submit(() ->{
            try
            {
                connectionService.updateStateInfo(stateReportDto);
                flowAnalysisService.updateFlowInfo(stateReportDto);
            } catch (ExecutionException e)
            {
                log.warn("更新用户连接缓存失败");
                log.error(e.toString());
            }
        });
        log.info(stateReportDto.toString());
        return ServerResponse.success();
    }


}
