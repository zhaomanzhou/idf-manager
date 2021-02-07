package com.idofast.admin.task;

import com.idofast.admin.domain.Order;
import com.idofast.admin.repository.OrderRepository;
import com.idofast.admin.service.manager.OrderManager;
import com.idofast.common.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/6 8:20 下午
 */
@Component
@Slf4j
public class CloseOrderTask
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderManager orderManager;


    @Scheduled(cron = "0 0 0/2 * * ?")
    public void test()
    {
        log.info("--------------开始进行取消订单定时任务--------------------------");
        List<Order> orders = orderRepository.findAllByCreateTimeAfterAndOrderStatusBefore(LocalDateTime.now().plusHours(-1), OrderStatusEnum.SUCCESS);
        for(Order order: orders)
        {
            log.info("处理超时取消订单{}", order.toString());
            if(order.getCreateTime().plusHours(2).isAfter(LocalDateTime.now()))
            {
                log.info("该订单还未到两小时，跳过");
                continue;
            }

            try
            {
                orderManager.cancelOrder(order.getId(), OrderStatusEnum.CANCEL_TIMEOUT);

            } catch (Exception e)
            {
                log.warn("订单{}在取消订单时出现了异常，异常内容{}", order.getId(), e.getMessage());
            }
        }

        log.info("--------------取消订单定时任务结束--------------------------");
    }
}
