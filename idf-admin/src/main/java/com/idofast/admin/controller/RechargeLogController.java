package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.controller.vo.response.RechargeLogVo;
import com.idofast.admin.domain.RechargeLog;
import com.idofast.admin.repository.RechargeLogRepository;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 4:57 下午
 */

@RestController
@RequestMapping("/rechargelog")
@Api(tags = "用户充值记录相关的api")
@CrossOrigin
@Slf4j
public class RechargeLogController
{

    @Autowired
    private RechargeLogRepository rechargeLogRepository;

    @ApiOperation("获取用户的充值记录接口")
    @GetMapping("/user/list")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<List<RechargeLogVo>> getRechargeLogByUserId(@NotNull Long userId)
    {
        List<RechargeLog> allByUserId = rechargeLogRepository.findAllByUserId(userId);
        List<RechargeLogVo> collect = allByUserId.stream()
                .map(RechargeLogVo::convertToVo)
                .collect(Collectors.toList());
        return ServerResponse.success(collect);

    }
}
