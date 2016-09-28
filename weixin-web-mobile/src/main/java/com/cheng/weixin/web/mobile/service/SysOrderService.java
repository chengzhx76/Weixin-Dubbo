package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.cart.model.ProductModel;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.order.entity.DeliveryTime;
import com.cheng.weixin.rpc.order.entity.OrderInfo;
import com.cheng.weixin.rpc.order.entity.Pay;
import com.cheng.weixin.rpc.order.enumType.PayStatus;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.rpc.user.entity.Account;
import com.cheng.weixin.rpc.user.entity.DeliveryAddress;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.result.order.OrderDeliveryTime;
import com.cheng.weixin.web.mobile.result.order.OrderList;
import com.cheng.weixin.web.mobile.result.order.OrderPay;
import com.cheng.weixin.web.mobile.result.order.SubmitOrderInfo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/14
 */
@Service("sysOrderService")
public class SysOrderService {
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcOrderService orderService;
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;

    public SubmitOrderInfo buy() {

        SubmitOrderInfo submitOrder = new SubmitOrderInfo();

        // 配送地址
        DeliveryAddress address = userService.getDefaultAddress("1");
        submitOrder.setConsignee(address.getConsignee());
        submitOrder.setMobile(address.getMobile());
        submitOrder.setAddress(address.getAddress());

        // 配送时间
        List<DeliveryTime> time = orderService.getAllDeliveryTime();
        List<OrderDeliveryTime> orderDeliveryTimes = new ArrayList<>();
        for (DeliveryTime deliveryTime : time) {
            orderDeliveryTimes.add(new OrderDeliveryTime(deliveryTime.getId(), deliveryTime.getName()));
        }
        submitOrder.setDeliveryTime(orderDeliveryTimes);

        // 支付方式
        List<Pay> pays = orderService.getAllPay();
        List<OrderPay> orderPays = new ArrayList<>();
        for (Pay pay : pays) {
            orderPays.add(new OrderPay(pay.getId(), pay.getName()));
        }
        submitOrder.setPays(orderPays);

        // 优惠券

        // 余额
        Account account = userService.getAccount("1");
        submitOrder.setAvailableBalance(StringFormat.format(account.getBalance()));

        // 商品详情
        int totalProductNums = 0;
        BigDecimal totalProductPrice = new BigDecimal(0);
        List<ProductModel> productModels = cartService.getChooseProductInfo("1");
        String[] productImgs = new String[productModels.size()];
        for (int i=0; i<productModels.size(); i++) {
            Product product = productService.getById(productModels.get(i).getId());
            productImgs[i] = product.getDefaultPicture().getPictureUrl();
            totalProductNums+=productModels.get(i).getCount();
            totalProductPrice = totalProductPrice.add(product.getSalePrice().multiply(new BigDecimal(productModels.get(i).getCount())));
        }
        submitOrder.setTotalProductNums(totalProductNums);
        submitOrder.setProductImgs(productImgs);
        submitOrder.setTotalPrice(StringFormat.format(totalProductPrice));
        // 运费
        BigDecimal freight = new BigDecimal(5.00);
        submitOrder.setFreight(StringFormat.format(freight));

        // 优惠券
        BigDecimal couponRecord = new BigDecimal(0.00);
        submitOrder.setCouponRecord(StringFormat.format(couponRecord));

        return submitOrder;
    }

    public List<OrderList> getOrders() {
        List<OrderInfo> orderInfos = orderService.getOrderInfos("1");
        List<OrderList> orders = new ArrayList<>();
        for (OrderInfo order : orderInfos) {
            OrderList orderList = new OrderList();
            orderList.setId(order.getId());
            orderList.setDate(new DateTime(order.getCreateDate()).toString("dd-MM-yyyy HH:mm:ss"));
            orderList.setOrderNum(order.getOid());
            orderList.setNumber(order.getOrderDetails().size()+"");
            orderList.setStatus(order.getFlowStatus().split("-"));
            // 总金额 = 商品总金额 - 优惠金额 + 应付运费
            orderList.setTotalPrice(StringFormat.format(order.getProductTotalPrice().subtract(order.getDiscount()).add(order.getFreightPayable())));
            String orderStatus = "";
            if (order.getPayStatus().equals(PayStatus.NONPAYMENT)) {
                orderStatus = "INVALID";
            } else if (StringUtils.isBlank(order.getCommentId())) {
                orderStatus = "WAITCOMMENT";
                orderList.setCommentId(order.getCommentId());
            }
            orderList.setOrderStatus(orderStatus);

            orders.add(orderList);
        }
        return orders;
    }


}
