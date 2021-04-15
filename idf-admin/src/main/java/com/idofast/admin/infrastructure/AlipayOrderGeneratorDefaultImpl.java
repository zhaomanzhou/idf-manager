package com.idofast.admin.infrastructure;

import com.idofast.admin.domain.Order;
import com.idofast.admin.infrastructure.declare.AlipayOrderGenerator;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/5 10:31 下午
 */
@Component
public class AlipayOrderGeneratorDefaultImpl implements AlipayOrderGenerator
{
    @Override
    public String generateOrderName(Order order)
    {
        return order.getId() + "_" + order.getBundleId();
    }
}
