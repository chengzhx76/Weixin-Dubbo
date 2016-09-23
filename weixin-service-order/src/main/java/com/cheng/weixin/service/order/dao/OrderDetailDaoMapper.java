package com.cheng.weixin.service.order.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.order.entity.OrderDetail;

import java.util.List;

/**
 * Desc: 订单子项表-客服
 * Author: hp
 * Date: 2016/9/9
 */
public interface OrderDetailDaoMapper extends BaseDaoMapper<OrderDetail> {
    /**
     * 获取该订单下的详情
     * @param orderDetail
     * @return
     */
    List<OrderDetail> loadByOrder(OrderDetail orderDetail);
}
