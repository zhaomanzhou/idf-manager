package com.idofast.proxy.web.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:57 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProxyAccountAdaptTest
{

    @Autowired
    private ProxyAccountAdapt accountAdapt;

    @Test
    public void getRemoteV2rayAccountDto()
    {
//        System.out.println(accountAdapt.getRemoteV2rayAccountDto(12233L));
    }
}