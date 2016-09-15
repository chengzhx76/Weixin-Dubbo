package com.cheng.weixin.service.order.service;

import com.cheng.weixin.rpc.order.entity.DeliveryTime;
import com.cheng.weixin.rpc.order.entity.Pay;
import com.cheng.weixin.rpc.order.service.RpcOrderService;
import com.cheng.weixin.service.order.dao.DeliveryTimeDaoMapper;
import com.cheng.weixin.service.order.dao.PayDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Desc: 订单
 * Author: 光灿
 * Date: 2016/9/14
 */
public class OrderService implements RpcOrderService {

    @Autowired
    private DeliveryTimeDaoMapper deliveryTimeDao;
    @Autowired
    private PayDaoMapper payDao;

    @Override
    public List<DeliveryTime> getAllDeliveryTime() {
        return deliveryTimeDao.loadAll();
    }

    @Override
    public List<Pay> getAllPay() {
        return payDao.loadAll();
    }
}
