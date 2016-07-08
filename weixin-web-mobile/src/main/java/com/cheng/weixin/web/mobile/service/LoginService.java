package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 登录
 * Author: cheng
 * Date: 2016/7/8
 */
@Service("loginService")
public class LoginService {

    @Autowired
    private RpcRedisService redisService;


}
