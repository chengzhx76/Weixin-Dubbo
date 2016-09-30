package com.cheng.weixin.rpc.user.service;

import com.cheng.weixin.rpc.user.entity.*;

import java.math.BigDecimal;

/**
 * Desc: 用户
 * Author: cheng
 * Date: 2016/7/7
 */
public interface RpcUserService {
    /**
     * 根据登陆账号获取该账号信息
     * @param loginName
     * @return
     */
    Account getAccountByLoginName(String loginName);

    /**
     * 保存帐号信息
     * @param phone
     * @param password
     * @param nickname
     */
    void saveAccess(String phone, String password, String nickname, String ip);

    /**
     * 登陆验证
     * @param username
     * @param password
     * @param loginIp
     * @return
     */
    String validateLogin(String username, String password, String loginIp);

    /**
     * 获取默认的配送地址
     * @return
     */
    DeliveryAddress getDefaultAddress(String userId);

    /**
     * 获取用户账户信息
     * @param userId
     * @return
     */
    Account getAccount(String userId);

    /**
     * 更新帐户金额
     * @param userId
     */
    void updateAccountBalance(String userId, BigDecimal subAmount);

    /**
     * 保存动作
     * @param behavior
     */
    void addBehavior(Behavior behavior);

    /**
     * 积分记录
     * @param userId
     */
    BonusPointRecord getBonusPointRecord(String userId);

    /**
     * 保存积分
     * @param bonusPointRecord
     */
    void addBonusPointRecord(BonusPointRecord bonusPointRecord);

    /**
     * 获取用户券记录
     * @param userId
     * @return
     */
    CouponRecord getCouponRecordByUser(String userId);

    /**
     * 保存券记录
     * @param couponRecor
     */
    void addCouponRecord(CouponRecord couponRecor);

    /**
     * 根据用户获取现金记录
     * @param userId
     * @return
     */
    CashRecord getCashRecord(String userId);

    /**
     * 保存现金记录
     * @param cashRecord
     */
    void addCashRecord(CashRecord cashRecord);
}
