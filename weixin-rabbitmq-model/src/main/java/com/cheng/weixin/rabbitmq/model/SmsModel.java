package com.cheng.weixin.rabbitmq.model;

/**
 * Desc: 短消息
 * Author: 光灿
 * Date: 2016/7/9
 */
public class SmsModel {
    private String phone;       // 手机号
    private String userIp;      // IP地址

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
