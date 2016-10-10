package com.cheng.weixin.service.order.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.order.entity.OrderProductDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Desc: 订单子项表-客服
 * Author: hp
 * Date: 2016/9/9
 */
@Repository
public interface OrderProductDetailDaoMapper extends BaseDaoMapper<OrderProductDetail> {
    /**
     * 获取该订单下的详情
     * @param orderDetail
     * @return
     */
    List<OrderProductDetail> loadByOrder(OrderProductDetail orderDetail);
}
