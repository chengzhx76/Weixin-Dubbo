package com.cheng.weixin.web.mobile.security.impl;

import com.cheng.weixin.common.utils.CodecUtil;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.web.mobile.security.TokenManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Desc: 默认令牌管理器
 * Author: cheng
 * Date: 2016/6/21
 */
public class DefaultTokenManager implements TokenManager {

    private static Map<String, String> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String createToken(String username) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, username);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtils.isEmpty(token) && tokenMap.containsKey(token);
    }
}
