package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.result.order.OrderDetail;
import com.cheng.weixin.web.mobile.result.order.OrderList;
import com.cheng.weixin.web.mobile.result.order.SubmitOrderInfo;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Desc: 订单
 * Author: hp
 * Date: 2016/9/9
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    @Autowired
    private SysOrderService orderService;

    /** 购买 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/buy")
    public ResponseEntity<Response> buy() {
        SubmitOrderInfo orderInfo = orderService.buy();
        return success(orderInfo);
    }

    /** 订单列表 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/orders")
    public ResponseEntity<Response> orders() {
        List<OrderList> orders = orderService.getOrders();
        return success(orders);
    }

    /** 订单详情 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/detail")
    public ResponseEntity<Response> orderDetail() {
        OrderDetail order = orderService.getOrderDetail();
        return success(order);
    }


}
