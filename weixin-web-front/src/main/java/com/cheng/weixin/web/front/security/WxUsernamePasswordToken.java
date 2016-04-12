package com.cheng.weixin.web.front.security;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Author: Cheng
 * Date: 2016/1/26 0026
 */
public class WxUsernamePasswordToken extends UsernamePasswordToken {
    /** 验证码 **/
    private String captcha;
    /** 是否是手机登录 **/
    private boolean mobilelogin;

    public WxUsernamePasswordToken() { super();}

    public WxUsernamePasswordToken(String username, char[] password, boolean rememberMe,
                                   String host, boolean mobilelogin, String captcha) {
        super(username, password, rememberMe, host);
        this.mobilelogin = mobilelogin;
        this.captcha = captcha;
    }

    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
    public boolean isMobilelogin() {
        return mobilelogin;
    }
    public void setMobilelogin(boolean mobilelogin) {
        this.mobilelogin = mobilelogin;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
