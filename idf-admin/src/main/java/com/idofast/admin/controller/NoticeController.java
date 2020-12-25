package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.controller.vo.request.NoticeAddVo;
import com.idofast.admin.controller.vo.response.NoticeResponseVo;
import com.idofast.admin.domain.Notice;
import com.idofast.admin.domain.User;
import com.idofast.admin.exception.BusinessErrorEnum;
import com.idofast.admin.service.NoticeService;
import com.idofast.admin.service.UserService;
import com.idofast.common.enums.NoticeStatusEnum;
import com.idofast.common.enums.NoticeVisibilityEnum;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/notice")
@Api(tags = "公告相关的api")
@CrossOrigin
public class NoticeController
{
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    @ApiOperation("添加公告")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<String> addNotice(@Validated NoticeAddVo noticeAddVo)
    {
        Notice notice = NoticeAddVo.convertToNotice(noticeAddVo);
        notice.setPublisherId(RequestContext.getCurrentUser().getId());
        noticeService.addNotice(notice);
        return ServerResponse.success();
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("根据id获取文章内容")
    public ServerResponse<NoticeResponseVo> getNoticeById(@PathVariable("id") Long id) throws BusinessException
    {
        Notice noticeById = noticeService.getNoticeById(id);
        if(noticeById.getStatus() != NoticeStatusEnum.PUBLISHED)
        {
            throw new BusinessException(BusinessErrorEnum.NOTICE_NOT_EXIST);
        }

        //所有人可见，直接返回
        if(noticeById.getVisibility() == NoticeVisibilityEnum.ALL)
        {
            return ServerResponse.success(NoticeResponseVo.convertFrom(noticeById));
        }

        String token = RequestContext.getToken();

        //需要登陆，进行校验
        User userByToken = null;
        try
        {
            userByToken = userService.getUserByToken(token);
        } catch (BusinessException e)
        {
            throw new BusinessException(BusinessErrorEnum.NEED_LOGIN);
        }

        if(noticeById.getVisibility() == NoticeVisibilityEnum.USER)
        {
            return ServerResponse.success(NoticeResponseVo.convertFrom(noticeById));
        }

        //此处权限只能是管理员权限
        if(userByToken.getRole() != RoleEnum.ADMIN)
        {
            throw new BusinessException(BusinessErrorEnum.OUT_OF_AUTORITY);
        }

        return ServerResponse.success(NoticeResponseVo.convertFrom(noticeById));
    }

    @GetMapping("/list/user/notification")
    @ApiOperation("获取所有公告列表")
    public ServerResponse<List<NoticeResponseVo>> getNotificationList()
    {
        List<Notice> noticeList = noticeService.getAllNoticeForSimpleUser();
        List<NoticeResponseVo>  noticeListVo= noticeList.stream().map(NoticeResponseVo::convertFrom)
                .collect(Collectors.toList());
        return ServerResponse.success(noticeListVo);
    }

}
