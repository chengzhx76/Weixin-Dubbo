package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.promotion.entity.CouponCode;
import com.cheng.weixin.rpc.promotion.enums.CouponType;
import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import com.cheng.weixin.web.mobile.result.Promotion.CouponDto;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;

    public List<CouponDto> getCouponByUser() {
        List<CouponCode> couponCodes = couponService.getCouponCodeByUser("1");
        List<CouponDto> coupons = new ArrayList<>();
        for (CouponCode code : couponCodes) {
            CouponDto coupon = new CouponDto();
            coupon.setTitle(code.getCoupon().getName());
            coupon.setFaceValue(StringFormat.format(code.getCoupon().getFaceValue()));
            coupon.setEnoughMoney(StringFormat.format(code.getCoupon().getEnoughMoney()));
            coupon.setBeginTime(new DateTime(code.getCoupon().getBeginTime()).toString("yyyy-MM-dd HH:MM:ss"));
            coupon.setEndTime(new DateTime(code.getCoupon().getEndTime()).toString("yyyy-MM-dd HH:MM:ss"));
            coupons.add(coupon);
        }
        return coupons;
    }

    public List<CouponDto> getUsableCouponAtOrderByUser() {
        List<CouponCode> couponCodes = couponService.getCouponCodeByUser("1");
        BigDecimal productTotalPrice = BigDecimal.ZERO;
        Set<String> productIds = cartService.getChooseProductIds("1");
        for (String productId : productIds) {
            Product product = productService.getById(productId);
            if (product.getUnitsInStock() > 0) {
                Long count = cartService.getCounts("1", productId);
                productTotalPrice = productTotalPrice.add(product.getSalePrice().multiply(new BigDecimal(count)));
            }
        }

        List<CouponDto> coupons = new ArrayList<>();
        for (CouponCode code : couponCodes) {
            boolean flag = false;
            // 只有红包券才是满减券 || 暂时只有满减券
            if (CouponType.LUCKYMONEY.equals(code.getCoupon().getType())) {
                boolean productPrice = productTotalPrice.compareTo(code.getCoupon().getEnoughMoney()) == 0
                        || productTotalPrice.compareTo(code.getCoupon().getEnoughMoney()) == 1;
                flag = productPrice;
            } /*else {
                // 是否包含该商品ID
                if (code.getCoupon().getIncludeGroup()!=null && !"".equals(code.getCoupon().getIncludeGroup())) {
                    boolean contain = true;
                    List<String> includeIds = Arrays.asList(StringUtils.split(code.getCoupon().getIncludeGroup(), ","));
                    for (String id : productIds) {
                        if (!includeIds.contains(id)) {
                            contain = false;
                            break;
                        }
                    }
                    flag = contain;
                }
                if (code.getCoupon().getExcludeGroup()!=null && !"".equals(code.getCoupon().getExcludeGroup())) {
                    boolean notContain = true;
                    List<String> notIncludeIds = Arrays.asList(code.getCoupon().getExcludeGroup().split(","));
                    for (String id : productIds) {
                        if (notIncludeIds.contains(id)) {
                            notContain = false;
                        }
                    }
                    flag = flag || notContain;
                }
            }*/

            CouponDto coupon = new CouponDto();
            coupon.setCouponId(code.getId());
            coupon.setTitle(code.getCoupon().getName());
            coupon.setFaceValue(StringFormat.format(code.getCoupon().getFaceValue()));
            coupon.setEnoughMoney(StringFormat.format(code.getCoupon().getEnoughMoney()));
            coupon.setBeginTime(new DateTime(code.getCoupon().getBeginTime()).toString("yyyy-MM-dd HH:MM:ss"));
            coupon.setEndTime(new DateTime(code.getCoupon().getEndTime()).toString("yyyy-MM-dd HH:MM:ss"));
            coupon.setUsable(flag);
            coupons.add(coupon);
        }
        return coupons;
    }

}
