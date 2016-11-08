package com.cheng.weixin.service.promotion.service;

import com.cheng.weixin.rpc.promotion.entity.Coupon;
import com.cheng.weixin.rpc.promotion.entity.CouponCode;
import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import com.cheng.weixin.service.promotion.dao.CouponCodeDaoMapper;
import com.cheng.weixin.service.promotion.dao.CouponDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/7
 */
@Service("couponService")
public class CouponService implements RpcCouponService {
    @Autowired
    private CouponCodeDaoMapper couponCodeDao;
    @Autowired
    private CouponDaoMapper couponDao;

    @Override
    public List<CouponCode> getCouponCodeByUser(String userId) {
        List<CouponCode> couponCodes = couponCodeDao.loadAll(new CouponCode(userId));
        for (CouponCode couponCode : couponCodes) {
            Coupon coupon = couponDao.load(new Coupon(couponCode.getId()));
            couponCode.setCoupon(coupon);
        }
        return couponCodes;
    }

}
