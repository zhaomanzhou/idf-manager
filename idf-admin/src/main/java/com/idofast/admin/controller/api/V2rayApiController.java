package com.idofast.admin.controller.api;

import com.idofast.admin.service.V2rayApiService;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:11 下午
 */

@RestController
@RequestMapping("/proxy/api")
@Api(tags = "订单相关的api")
@CrossOrigin
@Slf4j
@Validated
public class V2rayApiController
{

   @Autowired
   private V2rayApiService v2rayApiService;

   @RequestMapping("/detail")
   @ApiOperation("获取用户信息")
    public ServerResponse<V2rayAccountDto> getAccountById(@NonNull Long id) throws BusinessException
    {
        V2rayAccountDto v2rayAccountDto = v2rayApiService.queryById(id);
        return ServerResponse.success(v2rayAccountDto);
    }

}
