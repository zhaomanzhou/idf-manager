package com.idofast.admin.service;

import com.idofast.admin.domain.dto.UserInfoLite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/7/6 8:38 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserProxyInfoServiceTest
{

    @Autowired
    private UserProxyInfoService userProxyInfoService;

    @Test
    public void getUserList()
    {
        Pageable pageable = PageRequest.of(2,10);
        final Page<UserInfoLite> userList = userProxyInfoService.getUserList(pageable);
        System.out.println(userList.getPageable());
    }

    @Test
    public void testGetById()
    {
        System.out.println(userProxyInfoService.getUserInfoById(12233L));
    }

    @Test
    public void testGetByEmail()
    {
        System.out.println(userProxyInfoService.getUserInfoByEmail("zmzsstreet@163.com"));
    }
}