package com.idofast.admin.repository;

import com.idofast.admin.domain.Order;
import com.idofast.common.enums.OrderStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 4:00 下午
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    List<Order> findAllByUserId(Long userId);
    List<Order> findAllByOrderStatusBefore(OrderStatusEnum orderStatus);
    List<Order> findAllByCreateTimeAfterAndOrderStatusBefore(LocalDateTime startTime,OrderStatusEnum orderStatus);
}
