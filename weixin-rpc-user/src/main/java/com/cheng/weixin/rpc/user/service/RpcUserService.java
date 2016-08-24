package com.cheng.weixin.rpc.user.service;

import com.cheng.weixin.rpc.user.entity.Account;

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
}
