package com.cheng.weixin.web.mobile.security;

/**
 * Desc: 令牌管理器
 * Author: cheng
 * Date: 2016/6/22
 */
public interface TokenManager {

    String createToken(String username);

    boolean checkToken(String token);
}
