package com.idofast.admin.infrastructure.declare;

import com.idofast.admin.domain.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/5 10:29 下午
 */
@Component
public interface AlipayOrderGenerator
{
    public String generateOrderName(Order order);
}
