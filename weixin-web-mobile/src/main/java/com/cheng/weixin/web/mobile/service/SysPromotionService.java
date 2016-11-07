package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/7
 */
@Service("sysPromotion")
public class SysPromotionService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RpcCouponService couponService;



}
