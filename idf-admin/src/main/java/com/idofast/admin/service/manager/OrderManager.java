package com.idofast.admin.service.manager;

import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.idofast.admin.controller.vo.response.OrderForPayResponse;
import com.idofast.admin.domain.Order;
import com.idofast.admin.infrastructure.declare.AlipayOrderGenerator;
import com.idofast.admin.service.AliPayService;
import com.idofast.admin.service.OrderService;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.enums.PayTypeEnum;
import com.idofast.common.response.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


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

    @Autowired
    private AlipayOrderGenerator alipayOrderGenerator;

    /**
     * 为指定订单去调用支付宝生成支付信息
     * 会校验订单的用户id和传入的是否相同
     * @param orderId
     * @param userId
     * @return
     * @throws BusinessException
     */
    public OrderForPayResponse generateOrderPayment(Long orderId, Long userId) throws BusinessException
    {
        Order order = orderService.selectById(orderId);
        if(!order.getUserId().equals(userId))
        {
            throw new BusinessException("非法操作, CODE 44221");
        }
        if(order.getOrderStatus() != OrderStatusEnum.INITIAL_CREATED)
        {
            throw new BusinessException("该订单已生成对应的支付链接，请勿重复生成，请去订单管理页面查找");
        }

        AlipayTradePrecreateResponse response = aliPayService.toPay(alipayOrderGenerator.generateOrderName(order), Long.toString(orderId), order.getTotalMoney());
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


    /**
     * 取消订单，如果有支付宝交易号，则会去调用支付宝取消
     * @param orderId
     * @param orderStatusEnum
     * @throws Exception
     */
    public void cancelOrder(Long orderId, OrderStatusEnum orderStatusEnum) throws Exception
    {
        log.info("订单{}即将进行取消操作", orderId);
        if(orderStatusEnum != OrderStatusEnum.CANCEL_USER && orderStatusEnum != OrderStatusEnum.CANCEL_TIMEOUT )
        {
            throw new BusinessException("非法的订单取消原因");
        }
        Order order = orderService.selectById(orderId);
        if(order.getOrderStatus() == OrderStatusEnum.CANCEL_TIMEOUT || order.getOrderStatus() == OrderStatusEnum.CANCEL_USER)
        {
            throw new BusinessException("订单已取消");
        }

        if(order.getOrderStatus() == OrderStatusEnum.SUCCESS)
        {
            throw new BusinessException("订单已支付，不可取消");
        }
        AlipayTradeQueryResponse response = aliPayService.queryOrder(order.getId() + "");
         if(response.code.equals("40004"))
         {
             log.info("订单{}即将被取消，该订单未扫描二维码", orderId);
             order.setOrderStatus(orderStatusEnum);
             order.setCloseTime(LocalDateTime.now());
             orderService.updateOrder(order);
             return;
         }

        if(!ResponseChecker.success(response))
        {
            log.warn("订单{}调用支付宝查询失败，失败原因{}", orderId, response.msg + "，" + response.subMsg);
            throw new BusinessException("系统繁忙，请稍后尝试");
        }

        switch (response.tradeStatus)
        {
            case "WAIT_BUYER_PAY":
            {
                aliPayService.cancelOrder(orderId + "");
                order.setOrderStatus(orderStatusEnum);
                order.setCloseTime(LocalDateTime.now());
                orderService.updateOrder(order);
                return;
            }

            case "TRADE_CLOSED":
            {
                log.warn("订单{}支付宝方交易已关闭", orderId);
                order.setOrderStatus(orderStatusEnum);
                order.setCloseTime(LocalDateTime.now());
                orderService.updateOrder(order);
                return;
            }
            case "TRADE_SUCCESS":
            {
                log.warn("订单{}支付宝方交易已成功", orderId);
                throw new BusinessException("订单交易已成功，不可取消");
            }
            default:
            {
                throw new BusinessException("未知的订单错误");
            }
        }

    }
}
