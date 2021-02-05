package com.idofast.admin.service.manager;

import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.idofast.admin.controller.vo.response.OrderForPayResponse;
import com.idofast.admin.domain.Order;
import com.idofast.admin.service.AliPayService;
import com.idofast.admin.service.OrderService;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.enums.PayTypeEnum;
import com.idofast.common.response.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 11:00 下午
 */
@Service
@Slf4j
public class OrderManager
{

    @Autowired
    private OrderService orderService;

    @Autowired
    private AliPayService aliPayService;

    public OrderForPayResponse generateOrderPayment(Long orderId) throws BusinessException
    {
        Order order = orderService.selectById(orderId);
        if(order.getOrderStatus() != OrderStatusEnum.INITIAL_CREATED)
        {
            throw new BusinessException("该订单已生成对应的支付链接，请勿重复生成，请去订单管理页面查找");
        }

        AlipayTradePrecreateResponse response = aliPayService.toPay(order.getOrderName(), Long.toString(orderId), order.getTotalMoney());
        log.info(response.httpBody);
        order.setPayLink(response.getQrCode());
        order.setOrderStatus(OrderStatusEnum.WAIT_TO_SCAN);

        orderService.updateOrder(order);


        OrderForPayResponse orderForPayResponse = new OrderForPayResponse();
        orderForPayResponse.setOrderId(orderId);
        orderForPayResponse.setPayLink(response.getQrCode());
        orderForPayResponse.setPayType(PayTypeEnum.Alipay);
        orderForPayResponse.setTotalMoney(order.getTotalMoney());
        return orderForPayResponse;
    }
}
