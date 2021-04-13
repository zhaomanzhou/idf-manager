package com.idofast.admin.controller;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.controller.vo.page.PageResponse;
import com.idofast.admin.controller.vo.request.OrderSearchRequest;
import com.idofast.admin.controller.vo.response.OrderToAdminDetailVo;
import com.idofast.admin.controller.vo.response.OrderToAdminVo;
import com.idofast.admin.controller.vo.response.OrderToUserVo;
import com.idofast.admin.domain.Bundle;
import com.idofast.admin.domain.Order;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.exception.BusinessErrorEnum;
import com.idofast.admin.service.BundleService;
import com.idofast.admin.service.OrderService;
import com.idofast.admin.service.UserProxyInfoService;
import com.idofast.admin.service.manager.OrderManager;
import com.idofast.common.util.LocalDateTimeUtil;
import com.idofast.common.enums.OrderStatusEnum;
import com.idofast.common.enums.PayTypeEnum;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    private UserProxyInfoService proxyInfoService;

    @ApiOperation("创建订单")
    @PostMapping("/create")
    public ServerResponse<Order> createOrder(Long bundleId, Integer totalMonth, Integer payType) throws BusinessException
    {
        Bundle bundle = bundleService.findById(bundleId);

        UserProxyInfo proxyInfo = proxyInfoService.selectById(RequestContext.getCurrentUser().getId(), true);
        if(proxyInfo.getBundleId() != 0 && !proxyInfo.getBundleId().equals(bundleId) && proxyInfo.getExpireDate().isAfter(LocalDateTime.now()))
        {
            throw new BusinessException(BusinessErrorEnum.INVALID_BUNDLE_OPERATION);
        }

        Order order = Order.builder()
                .bundleName(bundle.getName())
                .orderName("IdoFast" + bundle.getName() + " " + totalMonth + "个月")
                .bundleId(bundleId)
                .totalMoney(bundle.getPrice()*totalMonth)
                .userId(RequestContext.getCurrentUser().getId())
                .userEmail(RequestContext.getCurrentUser().getEmail())
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

    @GetMapping("/admin/detail")
    @ApiOperation("获取订单详情")
    public ServerResponse<OrderToAdminDetailVo> selectById(Long orderId) throws BusinessException
    {
        Order order = orderService.selectById(orderId);
        return ServerResponse.success(OrderToAdminDetailVo.convertFromOrder(order));
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

    @ApiOperation("管理员获取订单列表")
    @GetMapping("/admin/list")
    @AuthRole(RoleEnum.ADMIN)
    public ServerResponse<PageResponse<OrderToAdminVo>> queryOrderListAdmin(@Validated OrderSearchRequest searchRequest)
    {
        PageRequest pageRequest = PageRequest.of(searchRequest.getCurrentPage() -1, searchRequest.getPageSize());

        Long id = searchRequest.getId();
        Long userId = searchRequest.getUserId();
        String userEmail = StringUtils.isBlank(searchRequest.getUserEmail()) ? null: searchRequest.getUserEmail();
        LocalDateTime startTime = LocalDateTimeUtil.toLocalDateTime(searchRequest.getStartTime());
        LocalDateTime endTime = LocalDateTimeUtil.toLocalDateTime(searchRequest.getEndTime());
        if(searchRequest.getOrderStatusList() == null)
        {
            searchRequest.setOrderStatusList(new ArrayList<>());
        }
        List<OrderStatusEnum> orderStatusEnumList = searchRequest.getOrderStatusList().stream()
                .map(OrderStatusEnum::ofCode)
                .collect(Collectors.toList());

        Page<Order> orders = orderService.selectOrderList(id, userId, userEmail,
                startTime, endTime, orderStatusEnumList, pageRequest);

        List<OrderToAdminVo> collect = orders.stream()
                .map(OrderToAdminVo::convertFromOrder)
                .collect(Collectors.toList());

        PageResponse<OrderToAdminVo> response = new PageResponse<>();
        response.setData(collect);
        response.setCurrentPageNum(searchRequest.getCurrentPage());
        response.setPageNum(orders.getTotalPages());
        response.setTotalElement(orders.getTotalElements());

        return ServerResponse.success(response);
    }




}
