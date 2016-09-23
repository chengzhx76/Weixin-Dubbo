package com.cheng.weixin.service.order.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.order.entity.OrderInfo;

import java.util.List;

/**
 * Desc: 订单
 * Author: hp
 * Date: 2016/9/9
 */
public interface OrderInfoDaoMapper extends BaseDaoMapper<OrderInfo> {
    /**
     * 获取该用户订单
     * @param userId
     * @return
     */
    List<OrderInfo> loadByUserId(String userId);

}
