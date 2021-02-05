package com.idofast.admin.controller;

import com.idofast.admin.controller.vo.response.OrderForPayResponse;
import com.idofast.admin.domain.Order;
import com.idofast.admin.exception.BusinessErrorEnum;
import com.idofast.admin.service.AliPayService;
import com.idofast.admin.service.BundleService;
import com.idofast.admin.service.OrderService;
import com.idofast.admin.service.manager.OrderManager;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.enums.PayTypeEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 4:08 下午
 */

@RestController
@RequestMapping("/pay")
@Api(tags = "付款相关的api")
@CrossOrigin
@Slf4j
@Validated
public class PayController
{
    @Autowired
    private BundleService bundleService;

    @Autowired
    private OrderService orderService;


    @Autowired
    private AliPayService aliPayService;

    @Autowired
    private OrderManager orderManager;

    @PostMapping("/create")
    public ServerResponse<OrderForPayResponse> payForOrder(Long orderId) throws BusinessException
    {
        OrderForPayResponse orderForPayResponse = orderManager.generateOrderPayment(orderId);
        return ServerResponse.success(orderForPayResponse);
    }

    @ApiOperation("获取订单支付信息，不存在则去调用支付宝接口创建")
    @GetMapping("/order/info")
    public ServerResponse<OrderForPayResponse> getOrCreatePayInfo(Long orderId) throws BusinessException
    {
        Order order = orderService.selectById(orderId);
        switch (order.getOrderStatus())
        {
            case CANCEL_TIMEOUT:
            case CANCEL: throw new BusinessException("该订单已取消");

            case SUCCESS:throw new BusinessException("该订单已支付成功，请勿重新支付");

            case WAIT_TO_PAY:{

                OrderForPayResponse orderForPayResponse = new OrderForPayResponse();
                orderForPayResponse.setOrderId(orderId);
                orderForPayResponse.setTradeNo(order.getTradeNo());
                orderForPayResponse.setPayLink(order.getPayLink());
                orderForPayResponse.setPayType(PayTypeEnum.Alipay);
                orderForPayResponse.setTotalMoney(order.getTotalMoney());
                return ServerResponse.success(orderForPayResponse);
            }

            case INITIAL_CREATED:{
                OrderForPayResponse orderForPayResponse = orderManager.generateOrderPayment(orderId);
                return ServerResponse.success(orderForPayResponse);
            }

        }
        throw new BusinessException(BusinessErrorEnum.UNKNOWN_ERROR);

    }

    @PostMapping("/callback")
    public String alipayCallback(HttpServletRequest request) throws Exception
    {
        boolean b = aliPayService.rsaCheck(request.getParameterMap());
        if(!b){
            log.warn("支付宝回调验签失败，请求IP{}", request.getRemoteHost());
            return  "FAIL";
        }

        Enumeration<String> parameterNames = request.getParameterNames();


        log.error("-------------------支付宝回调参数------------------");
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
           log.error(s + ": " + request.getParameter(s));
        }
        log.error("-------------------------------------------------");


        String tradeStatus = request.getParameter("trade_status"); // 交易状态
        String orderId = request.getParameter("out_trade_no"); // 商户订单号
        String tradeNo = request.getParameter("trade_no"); // 支付宝订单号
        String totalAmount = request.getParameter("total_amount");
        String buyerId = request.getParameter("buyer_id");
        String buyerLogonId = request.getParameter("buyer_logon_id");

        //扫码后的回调
        if(tradeStatus.equals("WAIT_BUYER_PAY")){
            Order order = orderService.selectById(Long.parseLong(orderId));
            if(order.getOrderStatus() == OrderStatusEnum.WAIT_TO_PAY){
                order.setTradeNo(tradeNo);
                order.setBuyerId(buyerId);
                order.setBuyerLogonId(buyerLogonId);
                orderService.updateOrder(order);
                return "SUCCESS";
            }
            return "FAIL";
            //订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
            //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
        }else if (tradeStatus.equals("TRADE_SUCCESS")){
            //付款完成后，支付宝系统发送该交易状态通知
            //验证支付成功后 需要验证是否更新过支付状态了
            Order order = orderService.selectById(Long.parseLong(orderId));

            if(!order.getTradeNo().equals(tradeNo)){
                log.warn("回调交易号与订单交易号不一致，订单号{}, 支付宝回调交易号{}, 订单交易号{}", orderId, tradeNo, order.getTradeNo());
                return "FAIL";
            }



            if (order.getOrderStatus() == OrderStatusEnum.SUCCESS){
                //并且同步回调时已经更改支付状态了 不做任何处理
                log.info("订单同步回调时已更新支付状态为已支付");
            }else if (order.getOrderStatus() == OrderStatusEnum.WAIT_TO_PAY){
                //支付成功 并且订单支付状态为待支付 更新状态为已支付
                orderService.updateOrderStatusPaid(Long.parseLong(orderId));
                log.info("修改订单状态成功");
            }
            return "SUCCESS";
        }
        return "FAIL";
    }


}
