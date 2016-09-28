package com.cheng.weixin.rpc.order.service;

import com.cheng.weixin.rpc.order.entity.DeliveryTime;
import com.cheng.weixin.rpc.order.entity.OrderInfo;
import com.cheng.weixin.rpc.order.entity.Pay;

import java.util.List;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/9/14
 */
public interface RpcOrderService {
    /**
     * 获取配送时间
     * @return
     */
    List<DeliveryTime> getAllDeliveryTime();

    /**
     * 获取所有的支付
     * @return
     */
    List<Pay> getAllPay();
    /**
     * 获取所有的支付
     * @return
     */
    Pay getPay(String id);

    /**
     * 获取所有的订单
     * @param userId
     * @return
     */
    List<OrderInfo> getOrderInfos(String userId);

    /**
     * 获取订单详情
     * @param userId
     * @return
     */
    OrderInfo getOrderDetail(String userId);

}
