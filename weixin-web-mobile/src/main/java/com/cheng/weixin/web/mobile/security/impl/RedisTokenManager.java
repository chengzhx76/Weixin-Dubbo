package com.cheng.weixin.web.mobile.security.impl;

import com.cheng.weixin.common.security.CodecUtil;
import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import com.cheng.weixin.rpc.user.entity.Account;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.security.LocalUser;
import com.cheng.weixin.web.mobile.security.TokenManager;
import com.cheng.weixin.web.mobile.security.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc: 基于 Redis 的令牌管理器
 * Author: cheng
 * Date: 2016/6/21
 */
public class RedisTokenManager implements TokenManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RpcRedisService redisService;
    @Autowired
    private RpcUserService userService;

    private static final long DEFAULT_SECONDS = 0;

    private long seconds = DEFAULT_SECONDS;

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String createToken(String username) {
        String token = CodecUtil.createUUID();
        if (seconds != 0) {
            redisService.set(token, username, seconds);
        } else {
            redisService.set(token, username);
        }
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        boolean result = redisService.exists(token);
        if(result) {
            if (seconds != 0) {
                redisService.flushExpireTime(token, seconds);
            }
            String loginName = (String) redisService.get(token);
            Account account = userService.getAccountByLoginName(loginName);
            LocalUser.setUser(new User(account.getId(), account.getUsername(), token));
        }
        return result;
    }
}
