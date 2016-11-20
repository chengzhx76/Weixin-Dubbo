package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.promotion.entity.CouponCode;
import com.cheng.weixin.rpc.promotion.service.RpcCouponService;
import com.cheng.weixin.rpc.user.entity.Account;
import com.cheng.weixin.rpc.user.entity.AccountLevel;
import com.cheng.weixin.rpc.user.entity.BonusPointRecord;
import com.cheng.weixin.rpc.user.entity.DeliveryAddress;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.result.user.DeliveryAddr;
import com.cheng.weixin.web.mobile.result.user.UserDetail;
import com.cheng.weixin.web.mobile.security.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 用户
 * Author: hp
 * Date: 2016/9/30
 */
@Service
public class SysUserService {
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcCouponService couponService;

    public UserDetail getUserDetail() {
        UserDetail userDetail = new UserDetail();
        Account account = userService.getAccount(LocalUser.getUser().getUserId());
        userDetail.setId(account.getId());
        userDetail.setNickname(account.getNickname());
        AccountLevel accountLevel = userService.getAccountLevelById(account.getAccountLevelId());
        userDetail.setAccountLevel(accountLevel.getLevel());
        userDetail.setBalance(StringFormat.format(account.getBalance()));
        userDetail.setBonusPointRecord(account.getBonusPointUsable());
        userDetail.setAvatar(account.getAvatar());
        userDetail.setUsername(account.getUsername());
        userDetail.setBonusPointUpgrade(account.getBonusPointUpgrade());

        List<CouponCode> couponCodes = couponService.getCouponCodeByUser(LocalUser.getUser().getUserId());
        if (couponCodes != null && !couponCodes.isEmpty()) {
            userDetail.setCouponRecord(couponCodes.size()+"");
        }else {
            userDetail.setCouponRecord("0");
        }
        List<BonusPointRecord> bonusPointRecords = userService.getByUSerIdAndCurrentMonth(LocalUser.getUser().getUserId());
        int currentMonthBonusPoint = 0;
        for (BonusPointRecord bonusPointRecord : bonusPointRecords) {
            currentMonthBonusPoint += bonusPointRecord.getTxBonusPoints();
        }
        userDetail.setCurrentMonthBonusPoint(currentMonthBonusPoint);
        return userDetail;
    }

    public List<DeliveryAddr> getDeliveryAddrs() {
        List<DeliveryAddress> addresses = userService.getAllDeliveryAddr(LocalUser.getUser().getUserId());

        List<DeliveryAddr> addrs = new ArrayList<>();
        for (DeliveryAddress address : addresses) {
            DeliveryAddr addr = new DeliveryAddr();
            addr.setAddrId(address.getId());
            addr.setConsignee(address.getConsignee());
            addr.setMobile(address.getMobile());
            addr.setAddress(address.getAddress());
            addr.setSex(address.getSex().getName());
            addr.setTag(address.getTag());
            addr.setDefault(address.getDefault());
            addrs.add(addr);
        }
        return addrs;
    }

}
