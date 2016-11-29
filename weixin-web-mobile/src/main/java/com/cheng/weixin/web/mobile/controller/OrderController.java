package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.common.model.Page;
import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.AddressDto;
import com.cheng.weixin.web.mobile.param.PaymentDto;
import com.cheng.weixin.web.mobile.result.order.*;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
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
    @RequestMapping(value = "v1/payment")
    public ResponseEntity<Response> payment(HttpServletRequest request) {
        PaymentDto payment = (PaymentDto) getDto(request, PaymentDto.class);
        SubmitOrderInfo orderInfo = orderService.payment(payment);
        return success(orderInfo);
    }

    /** 购买商品列表 **/
    @RequestMapping(value = "v1/product/list")
    public ResponseEntity<Response> productList() {
        List<ProductList> list = orderService.getProductList();
        return success(list);
    }

    /** 提交订单 **/
    @RequestMapping(value = "v1/buy")
    public ResponseEntity<Response> submitBuy(HttpServletRequest request) {
        PaymentDto payment = (PaymentDto) getDto(request, PaymentDto.class);
        BuyInfo buyInfo = orderService.buy(payment, request);
        return success(buyInfo);
    }


    /** 订单列表 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/orders")
    public ResponseEntity<Response> orders(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
        //PageDto page = (PageDto) getDto(request, PageDto.class);

        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        Page<OrderList> orders = orderService.getOrders(pageNum, pageSize);
        return success(orders);
    }

    /** 订单详情 **/
    @RequestMapping(value = "v1/detail")
    public ResponseEntity<Response> orderDetail() {
        Detail order = orderService.getOrderDetail();
        return success(order);
    }

    /** 自提地点-镇 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/ara/town")
    public ResponseEntity<Response> arayacakTownAddr() {
        List<ArayacakTownAddr> addrs = orderService.getAllTownArayacakAddr("1"); //TODO 默认成武
        return success(addrs);
    }
    /** 自提地点-村庄 **/
    @IgnoreSecurity
    @RequestMapping(value = "v1/ara/village")
    public ResponseEntity<Response> arayacakVillageAddr(HttpServletRequest request) {
        AddressDto address = (AddressDto) getDto(request, AddressDto.class);
        List<ArayacakVillageAddr> addrs = orderService.getAllVillageArayacakAddr(address.getId());
        return success(addrs);
    }
}
