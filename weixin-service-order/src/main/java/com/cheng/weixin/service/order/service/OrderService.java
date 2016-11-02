package com.cheng.weixin.service.order.service;

import com.cheng.weixin.rpc.order.entity.*;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.service.order.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 订单
 * Author: 光灿
 * Date: 2016/9/14
 */
@Service("orderService")
public class OrderService implements RpcOrderService {
    @Autowired
    private OrderInfoDaoMapper orderInfoDao;
    @Autowired
    private OrderProductDetailDaoMapper orderProductDetailDao;
    @Autowired
    private DeliveryTimeDaoMapper deliveryTimeDao;
    @Autowired
    private PayDaoMapper payDao;
    @Autowired
    private ArayacakAddressDaoMapper arayacakAddressDao;


    @Override
    public List<DeliveryTime> getAllDeliveryTime() {
        return deliveryTimeDao.loadAll();
    }

    @Override
    public List<Pay> getAllPay() {
        return payDao.loadAll();
    }

    @Override
    public List<OrderInfo> getOrderInfos(String userId) {
        List<OrderInfo> orderInfos = orderInfoDao.loadByUserId(new OrderInfo(userId));
        for (OrderInfo order : orderInfos) {
            List<OrderProductDetail> orderProductDetails = orderProductDetailDao.loadByOrder(new OrderProductDetail(order.getId()));
            order.setOrderDetails(orderProductDetails);
        }
        return orderInfos;
    }

    @Override
    public OrderInfo getOrderDetail(String id) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(id);
        return orderInfoDao.load(orderInfo);
    }

    @Override
    public void addOrder(OrderInfo orderInfo) {
        orderInfo.preInsert();
        orderInfoDao.save(orderInfo);
    }

    @Override
    public Pay getPay(String id) {
        return payDao.load(new Pay(id));
    }

    //@Override
    //public List<ArayacakAddress> getArayacakAddr(String cityId, String countryId) {
    //    return arayacakAddressDao.loadAll(new ArayacakAddress(cityId, countryId));
    //}
}
