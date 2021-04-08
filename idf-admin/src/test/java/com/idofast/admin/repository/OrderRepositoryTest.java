package com.idofast.admin.repository;

import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import com.idofast.admin.domain.Order;
import com.idofast.admin.service.AliPayService;
import com.idofast.common.enums.OrderStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
    private AliPayService aliPayService;

    @Test
    public void findAllByUserId()
    {
        System.out.println(orderRepository.findAllByUserId(2L));
    }

    @Test
    public void test2()
    {
        List<Order> orders = orderRepository.findAllByCreateTimeBeforeAndOrderStatusIsLessThan(LocalDateTime.now().plusHours(-1), OrderStatusEnum.SUCCESS);
        for(Order order: orders)
        {
            if(order.getCreateTime().plusHours(2).isAfter(LocalDateTime.now()))
            {
                continue;
            }

            try
            {
                AlipayTradeQueryResponse response = aliPayService.queryOrder(order.getId() + "");
            } catch (Exception e)
            {

            }
        }
    }
}