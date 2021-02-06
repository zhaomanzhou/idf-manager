package com.idofast.admin.controller;

import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.controller.vo.response.OrderToUserVo;
import com.idofast.admin.domain.Bundle;
import com.idofast.admin.domain.Order;
import com.idofast.admin.exception.BusinessErrorEnum;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 3:51 下午
 */

@RestController
@RequestMapping("/order")
@Api(tags = "订单相关的api")
@CrossOrigin
@Slf4j
@Validated
public class OrderController
{

    @Autowired
    private BundleService bundleService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderManager orderManager;

    @ApiOperation("创建订单")
    @PostMapping("/create")
    public ServerResponse<Order> createOrder(Long bundleId, Integer totalMonth, Integer payType) throws BusinessException
    {
        Bundle bundle = bundleService.findById(bundleId);
        Order order = Order.builder()
                .bundleName(bundle.getName())
                .orderName("IdoFast" + bundle.getName() + " " + totalMonth + "个月")
                .bundleId(bundleId)
                .totalMoney(bundle.getPrice()*totalMonth)
                .userId(RequestContext.getCurrentUser().getId())
                .orderStatus(OrderStatusEnum.INITIAL_CREATED)
                .payType(PayTypeEnum.ofCode(payType))
                .totalMonth(totalMonth)
                .build();
        Order newOrder = orderService.createOrder(order);
        return ServerResponse.success(newOrder);
    }

    @GetMapping("/check/isPaid")
    @ApiOperation("查询订单是否已支付")
    public ServerResponse<Boolean> checkOrderIsPaid(Long orderId) throws BusinessException
    {
        Order order = orderService.selectById(orderId);
        if(!RequestContext.getCurrentUser().getId().equals(order.getUserId()))
        {
            throw new BusinessException(BusinessErrorEnum.ILLEGAL_ORDER_USER);
        }
        Boolean success =  order.getOrderStatus() == OrderStatusEnum.SUCCESS;
        return ServerResponse.success(success);
    }

    @GetMapping("/detail")
    @ApiOperation("获取订单详情")
    //TODO
    public ServerResponse<Order> selectById(Long orderId) throws BusinessException
    {
        Order order = orderService.selectById(orderId);
        return ServerResponse.success(order);

    }


    @ApiOperation("获取用户所有的订单信息")
    @GetMapping("/user/list")
    public ServerResponse<List<OrderToUserVo>> getOrderList()
    {
        Long id = RequestContext.getCurrentUser().getId();
        List<Order> orders = orderService.selectByUserId(id);
        List<OrderToUserVo> collect = orders.stream()
                .map(OrderToUserVo::convertFromOrder)
                .collect(Collectors.toList());
        return ServerResponse.success(collect);
    }

    @ApiOperation("取消用户订单")
    @GetMapping("/cancel")
    public ServerResponse<String> cancelOrder(Long orderId) throws Exception
    {
        Long userId = RequestContext.getCurrentUser().getId();
        Order order = orderService.selectById(orderId);
        if(!order.getUserId().equals(userId)){
            throw new BusinessException(BusinessErrorEnum.ILLEGAL_ORDER_USER);
        }
        orderManager.cancelOrder(orderId, OrderStatusEnum.CANCEL_USER);
        return ServerResponse.success();
    }



}
