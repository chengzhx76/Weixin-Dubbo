package com.cheng.weixin.web.mobile.security;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/11/20
 */
public class User {
    private String userId;
    private String username;
    private String token;

    public User() {
    }

    public User(String userId, String username, String token) {
        this.userId = userId;
        this.username = username;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("username", username)
                .append("token", token)
                .toString();
    }
}
