package com.idofast.admin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 11:39 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryTest
{
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findAllByUserId()
    {
        System.out.println(orderRepository.findAllByUserId(2L));
    }
}