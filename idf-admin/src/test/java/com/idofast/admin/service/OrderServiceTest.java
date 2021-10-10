package com.idofast.admin.service;

import com.idofast.admin.domain.Order;
import com.idofast.common.response.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/5 11:44 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest
{
    @Autowired
    private OrderService orderService;

    @Test
    public void updateOrderStatusPaid() throws BusinessException
    {
        orderService.updateOrderStatusPaid(2L);
    }

    @Test
    public void testUpdateOrder()
    {
        List<Order> orders = orderService.selectUnpaidOrder();
        orders.stream().forEach(
                System.out::println
        );
    }



}