package com.idofast.admin.service;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 4:00 下午
 */

import com.idofast.admin.domain.Order;
import com.idofast.admin.repository.OrderRepository;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.response.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * 查询指定用户的所有订单
     */
    public List<Order> selectByUserId(Long userId)
    {
        List<Order> allByUserId = orderRepository.findAllByUserId(userId);
        return allByUserId;
    }

    /**
     * 根据订单id查询指定订单
     */
    public Order selectById(Long orderId) throws BusinessException
    {
        Optional<Order> byId = orderRepository.findById(orderId);
        if(byId.isEmpty()){
            throw new BusinessException("该订单不存在");
        }

        return byId.get();
    }

    /**
     * 将指定订单的状态更改为已支付
     */
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

    /**
     * 查询为支付的系统订单，定时关单任务调用
     * @return
     */
    public List<Order> selectUnpaidOrder()
    {
        List<Order> orders = orderRepository.findAllByOrderStatusBefore(OrderStatusEnum.CANCEL_USER);
        return orders;
    }



    public void updateOrder(Order order)
    {
        orderRepository.save(order);
    }

    public Page<Order> selectOrderList(Long id,Long userId, String userEmail, LocalDateTime startTime, LocalDateTime endTime, List<OrderStatusEnum> orderStatusList, Pageable pageable)
    {
        Order order = new Order();
        Optional.ofNullable(id).ifPresent(order::setId);
        Optional.ofNullable(userId).ifPresent(order::setUserId);
        Optional.ofNullable(userEmail).ifPresent(order::setUserEmail);

        Page<Order> all = orderRepository.findAll(orderRepository.exampleSpecification(Example.of(order))
                .and(orderRepository.orderListSpec(startTime, endTime, orderStatusList)), pageable);
        return all;
    }

}
