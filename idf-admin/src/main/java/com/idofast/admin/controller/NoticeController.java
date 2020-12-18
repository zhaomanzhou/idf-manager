package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.controller.vo.request.NoticeAddVo;
import com.idofast.admin.service.NoticeService;
import com.idofast.common.enums.RoleEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("/user")
@Api(tags = "公告相关的api")
@CrossOrigin
@Slf4j
@Validated
public class NoticeController
{
    private NoticeService noticeService;


    @PostMapping("/add")
    @ApiOperation("添加公告")
    @AuthRole(value = RoleEnum.ADMIN)
    public void addNotice(@Validated NoticeAddVo noticeAddVo)
    {

    }
}
