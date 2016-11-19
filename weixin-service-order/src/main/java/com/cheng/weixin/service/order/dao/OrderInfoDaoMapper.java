package com.cheng.weixin.service.order.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.order.entity.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Desc: 订单
 * Author: hp
 * Date: 2016/9/9
 */
@Repository
public interface OrderInfoDaoMapper extends BaseDaoMapper<OrderInfo> {
    /**
     * 获取该用户订单
     * @param orderInfo
     * @return
     */
    List<OrderInfo> loadByUserIdOrderByCreateDate(OrderInfo orderInfo);

}
