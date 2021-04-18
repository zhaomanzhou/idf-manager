package com.idofast.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/17 11:46 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NodeServiceTest
{
    @Autowired
    private NodeService nodeService;

    @Test
    public void getNodeListForSimpleUser()
    {
        nodeService.getNodeListForSimpleUser();
    }

    @Test
    public void getByHost()
    {
        System.out.println(nodeService.getByHost("qy.zmz121.cn"));
    }
}