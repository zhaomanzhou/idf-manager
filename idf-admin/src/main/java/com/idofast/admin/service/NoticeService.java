package com.idofast.admin.service;

import com.idofast.admin.domain.Notice;
import com.idofast.admin.repository.NoticeRepository;
import com.idofast.admin.service.manager.NoticeManager;
import com.idofast.common.enums.NoticeTypeEnum;
import com.idofast.common.enums.NoticeVisibilityEnum;
import com.idofast.common.response.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeService
{
    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeManager noticeManager;


    public void addNotice(Notice notice)
    {
        noticeRepository.save(notice);
    }



    public List<Notice> getAllNoticeForAdmin()
    {
        return noticeManager.getNoticeList(null, null);
    }

    /**
     * 普通用户获取公告列表
     */
    public List<Notice> getAllNoticeForSimpleUser()
    {
        return noticeManager.getNoticeList(NoticeTypeEnum.NOTIFICATION, NoticeVisibilityEnum.USER);
    }



    /**
     * 普通用户获取教程列表
     */
    public List<Notice> getAllInstructionForSimpleUser()
    {
        return noticeManager.getNoticeList(NoticeTypeEnum.INSTRUCTION, NoticeVisibilityEnum.USER);
    }


    public Notice getNoticeById(Long id) throws BusinessException
    {

        Optional<Notice> byId = noticeRepository.findById(id);
        if(byId.isPresent())
        {
            return byId.get();
        }
        throw new BusinessException("该文章不存在");
    }
}
