package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.domain.SystemPreference;
import com.idofast.admin.domain.enums.SystemPreferenceEnum;
import com.idofast.admin.service.SystemPreferenceService;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/8 6:03 下午
 */
@RestController
@RequestMapping("/system/preference")
@Api(tags = "系统设置相关的api")
@CrossOrigin
@Slf4j
public class SystemPreferenceController
{

    @Autowired
    private SystemPreferenceService preferenceService;


    @ApiOperation("获取所有的教程列表")
    @GetMapping("/instruction/list")
    public ServerResponse<List<SystemPreference>> getInstructionPreference()
    {
        List<SystemPreference> allInstruction = preferenceService.getAllInstruction();
        return ServerResponse.success(allInstruction);
    }

    @ApiOperation("获取所有的教程列表")
    @RequestMapping("/all/list")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<List<SystemPreference>> getAllPreference()
    {
        List<SystemPreference> allPreference = preferenceService.getAllPreference();
        return ServerResponse.success(allPreference);
    }






    @PostMapping("/update")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String> updateSystemPreference(@RequestParam Map<String, String> map)
    {

        for(Map.Entry<String, String> entry : map.entrySet())
        {
            log.info(entry.getKey() + "=" + entry.getValue());
            SystemPreferenceEnum preference = SystemPreferenceEnum.ofKey(entry.getKey());
            if(preference != null)
            {
                preferenceService.updatePreference(preference, entry.getValue());
            }

        }
        return ServerResponse.success();
    }
}
