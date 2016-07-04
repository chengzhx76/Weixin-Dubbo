package com.cheng.weixin.web.mobile.security;


import com.cheng.weixin.common.utils.ServletUtils;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.web.mobile.exception.TokenException;
import com.cheng.weixin.web.mobile.exception.message.HttpCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Desc: 用于检查 token 的切面
 * Author: cheng
 * Date: 2016/6/22
 */
public class SecurityAspect {

    private static final String DEFAULT_TOKEN_NAME = "X-Token";

    private TokenManager tokenManager;
    private String tokenName;

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    public void setTokenName(String tokenName) {
        if (StringUtils.isEmpty(tokenName)) {
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }

    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        // 若目标方法忽略了安全性检查，则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }
        // 从 request header 中获取当前 token
        //String token = ServletUtils.getRequest().getHeader(tokenName);
        String token = ServletUtils.getRequest().getParameter(tokenName);
        // 检查 token 有效性
        if (!tokenManager.checkToken(token)) {
            throw new TokenException(HttpCode.UNAUTHORIZED.msg());
        }
        // 调用目标方法
        return pjp.proceed();
    }
}
