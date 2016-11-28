package com.cheng.weixin.rpc.order.service;

import com.cheng.weixin.rpc.order.entity.*;
import com.cheng.weixin.rpc.order.enumType.PayWay;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.InvocationTargetException;
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
    PageInfo<OrderInfo> getOrderInfos(String userId, int pageNum, int pageSize) throws InvocationTargetException, IllegalAccessException;

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
    OrderInfo addOrder(OrderInfo orderInfo);

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

    /**
     * 根据支付方式获取不同的订单流程
     * @param payWay
     * @return
     */
    List<FlowStatus> getFlowStatusesByPayWay(PayWay payWay);

    /**
     * 根据ID获取订单流程名字
     * @param id
     * @return
     */
    FlowStatus getFlowStatusesById(String id);

    /**
     * 保存商品详情
     * @param detail
     * @return
     */
    OrderProductDetail addOrderDetail(OrderProductDetail detail);
}
