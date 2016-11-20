package com.cheng.weixin.web.mobile.security;

/**
 * Desc:
 * Author: 光灿
 * Date: 2016/11/20
 */
public class LocalUser {
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static void removeUser() {
        userThreadLocal.remove();
    }
}
