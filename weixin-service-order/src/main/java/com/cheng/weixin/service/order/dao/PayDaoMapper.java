package com.cheng.weixin.service.order.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.order.entity.Pay;
import org.springframework.stereotype.Repository;

/**
 * Desc: 支付方式：微信支付，支付宝支付，货到付款
 * Author: hp
 * Date: 2016/9/9
 */
@Repository
public interface PayDaoMapper extends BaseDaoMapper<Pay> {
}
