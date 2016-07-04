package com.cheng.weixin.web.mobile.interceptor;

import com.cheng.weixin.common.security.Digests;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import com.cheng.weixin.web.mobile.exception.IllegalParameterException;
import com.cheng.weixin.web.mobile.exception.message.HttpCode;
import com.cheng.weixin.web.mobile.properties.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc: 恶意请求拦截器
 * Author: cheng
 * Date: 2016/6/24
 */
public class MaliciousRequestInterceptor extends HandlerInterceptorAdapter {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RpcRedisService redisService;

    private static final String DEFAULT_TOKEN_NAME = "X-Token";
    private static final String DEFAULT_APP_KEY_NAME = "X-AppKey";
    private static final String DEFAULT_TIME_STAMP_NAME = "timestamp";
    private static final String DEFAULT_SIGN_NAME = "sign";
    private static final String DEFAULT_PARAM_NAME = "param";
    private static final Long DEFAULT_REQUEST_TIME_INTERVAL = 5 * 60 * 1000L;

    private String tokenName;
    private String appKeyName;
    private String timestampName;
    private String signName;
    private String paramName;
    private Long minRequestIntervalTime; // 允许的最小请求间隔

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String appKey = request.getHeader(appKeyName);
        String appKey = request.getParameter(appKeyName);
        String timestamp = request.getParameter(timestampName);
        if(StringUtils.isAnyBlank(timestamp, appKey)) {
            throw new IllegalParameterException(HttpCode.BAD_REQUEST.msg());
        }

        // 请求时间超过5分钟
        if (StringUtils.isNotBlank(timestamp)) {
            long differ = System.currentTimeMillis() - Long.parseLong(timestamp);
            if (differ > minRequestIntervalTime) {
                response.setStatus(HttpCode.MULTI_STATUS.value());
                logger.warn("To intercept a malicious request : {}", request.getServletPath());
                return false;
            }
        }


        // 是否是已授权的APP请求
        Properties properties = Properties.getInstance();
        String appSecret = properties.getValue(appKey);
        if(StringUtils.isBlank(appSecret)) {
            response.setStatus(HttpCode.FORBIDDEN.value());
            return false;
        }
        // 验证签名
        StringBuilder sb = new StringBuilder();
        sb.append(appKey);
        sb.append(timestamp);
        //String token = request.getHeader(tokenName);
        String token = request.getParameter(tokenName);
        if (StringUtils.isNotBlank(token)) sb.append(token);
        String parameter = request.getParameter(paramName);//接受参数
        if (StringUtils.isNotBlank(parameter)) sb.append(parameter);

        String signParam = request.getParameter(signName);//接受签名

        logger.info("待签名数据=====> "+sb.toString());

        String sign = Digests.md5(sb.toString());
        logger.info("md5后=====> "+sign);
        if (signParam.equals(sign)) {
            // 去redis查看是否有sign这个值；如果有则返回fase；否则没有返回true 并存储到redis里
            boolean isExist = redisService.exists(sign);
            if (isExist) {
                response.setStatus(HttpCode.FORBIDDEN.value());
                return false;
            }else {
                redisService.set(sign, signName, 300L);
            }
        }else {
            response.setStatus(HttpCode.FORBIDDEN.value());
            return false;
        }
        return true;
    }

    public void setTokenName(String tokenName) {
        if (StringUtils.isEmpty(tokenName)) {
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }
    public void setAppKeyName(String appKeyName) {
        if (StringUtils.isEmpty(appKeyName)) {
            appKeyName = DEFAULT_APP_KEY_NAME;
        }
        this.appKeyName = appKeyName;
    }
    public void setTimestampName(String timestampName) {
        if (StringUtils.isEmpty(timestampName)) {
            timestampName = DEFAULT_TIME_STAMP_NAME;
        }
        this.timestampName = timestampName;
    }

    public void setSignName(String signName) {
        if (StringUtils.isEmpty(signName)) {
            signName = DEFAULT_SIGN_NAME;
        }
        this.signName = signName;
    }

    public void setParamName(String paramName) {
        if (StringUtils.isEmpty(paramName)) {
            paramName = DEFAULT_PARAM_NAME;
        }
        this.paramName = paramName;
    }

    public void setMinRequestIntervalTime(Long minRequestIntervalTime) {
        if (minRequestIntervalTime != null) {
            minRequestIntervalTime = DEFAULT_REQUEST_TIME_INTERVAL;
        }
        this.minRequestIntervalTime = minRequestIntervalTime;
    }

}
