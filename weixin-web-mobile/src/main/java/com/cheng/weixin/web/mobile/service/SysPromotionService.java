package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.promotion.entity.CouponCode;
import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import com.cheng.weixin.web.mobile.result.Promotion.CouponDto;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<CouponDto> getCouponByUser() {
        List<CouponCode> couponCodes = couponService.getCouponCodeByUser("1");
        List<CouponDto> coupons = new ArrayList<>();
        for (CouponCode code : couponCodes) {
            CouponDto coupon = new CouponDto();
            coupon.setTitle(code.getCoupon().getName()==null ? code.getCoupon().getType().getName() : code.getCoupon().getName());
            coupon.setFaceValue(StringFormat.format(code.getCoupon().getFaceValue()));
            coupon.setEnoughMoney(StringFormat.format(code.getCoupon().getEnoughMoney()));
            coupon.setBeginTime(new DateTime(code.getCoupon().getBeginTime()).toString("yyyy-MM-dd HH:MM:ss"));
            coupon.setEndTime(new DateTime(code.getCoupon().getEndTime()).toString("yyyy-MM-dd HH:MM:ss"));
            coupons.add(coupon);
        }
        return coupons;
    }

}
