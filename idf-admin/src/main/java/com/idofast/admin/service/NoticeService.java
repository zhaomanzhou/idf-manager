package com.idofast.admin.service;

import com.idofast.admin.domain.Notice;
import com.idofast.admin.repository.NoticeRepository;
import com.idofast.common.response.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void addNotice(Notice notice)
    {
        noticeRepository.save(notice);
    }

    public List<Notice> getNoticeList()
    {
        List<Sort.Order> sortList = new ArrayList<>();
        sortList.add(new Sort.Order(Sort.Direction.ASC, "stick"));
        sortList.add(new Sort.Order(Sort.Direction.ASC, "order_value"));
        Sort sort = Sort.by(sortList);
        List<Notice> all = noticeRepository.findAll(sort);
        return all;
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
