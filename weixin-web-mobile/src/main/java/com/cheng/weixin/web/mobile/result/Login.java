package com.cheng.weixin.web.mobile.result;

/**
 * Desc: 登陆
 * Author: 光灿
 * Date: 2016/8/17
 */
public class Login {
    private boolean success;
    private String token;

    public Login() {
    }

    public Login(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
