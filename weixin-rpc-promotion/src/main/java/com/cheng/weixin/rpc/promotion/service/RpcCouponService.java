package com.cheng.weixin.rpc.promotion.service;

import com.cheng.weixin.rpc.promotion.entity.CouponCode;

import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/7
 */
public interface RpcCouponService {
    /**
     * 获取用户的优惠券
     * @param userId
     * @return
     */
    List<CouponCode> getCouponCodeByUser(String userId);
}
