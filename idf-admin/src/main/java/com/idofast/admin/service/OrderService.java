package com.idofast.admin.service;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 4:00 下午
 */

import com.idofast.admin.domain.Order;
import com.idofast.admin.repository.OrderRepository;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.response.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 创建订单，返回订单的ID
     */
    public Order createOrder(Order order)
    {
        Order save = orderRepository.save(order);
        return save;
    }

    public List<Order> selectByUserId(Long userId)
    {
        List<Order> allByUserId = orderRepository.findAllByUserId(userId);
        return allByUserId;
    }

    public Order selectById(Long orderId) throws BusinessException
    {
        Optional<Order> byId = orderRepository.findById(orderId);
        if(byId.isEmpty()){
            throw new BusinessException("该订单不存在");
        }

        return byId.get();
    }


    public void updateOrderStatusPaid(Long id) throws BusinessException
    {
        Optional<Order> byId = orderRepository.findById(id);
        if(byId.isEmpty()){
            throw new BusinessException("订单不存在");
        }
        Order order = byId.get();
        order.setOrderStatus(OrderStatusEnum.SUCCESS);
        order.setPayTime(LocalDateTime.now());
        orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) throws BusinessException
    {
        Order order = selectById(orderId);

    }

    public void updateOrder(Order order)
    {
        orderRepository.save(order);
    }
}
