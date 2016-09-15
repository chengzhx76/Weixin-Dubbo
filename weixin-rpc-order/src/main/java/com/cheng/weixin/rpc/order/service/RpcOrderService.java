package com.cheng.weixin.rpc.order.service;

import com.cheng.weixin.rpc.order.entity.DeliveryTime;
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
}
