package com.cheng.weixin.rpc.order.service;

import com.cheng.weixin.rpc.order.entity.*;

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
    List<DeliveryTime> getAllDeliveryTimes();

    /**
     * 根据ID获取配送的时间
     * @param id
     * @return
     */
    DeliveryTime getDeliveryTime(String id);
    /**
     * 获取所有的支付
     * @return
     */
    List<Pay> getAllPay();
    /**
     * 获取支付
     * @return
     */
    Pay getPay(String id);

    /**
     * 获取推荐的支付
     * @return
     */
    Pay getRecommendPay();

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

    /**
     * 保存订单
     * @param orderInfo
     */
    void addOrder(OrderInfo orderInfo);

    /**
     * 获取全部镇自提地址 // 根据GPS获取自提地点->根据自提地点搜索地点的ID
     * @return
     */
    List<ArayacakAddress> getArayacakAddr(String countyId, String townId);

    /**
     * 根据ID获取镇
     * @param townId
     * @return
     */
    Town getTownById(String townId);

    /**
     * 根据ID获取自提地点
     * @param id
     * @return
     */
    ArayacakAddress getArayacakAddressById(String id);
}
