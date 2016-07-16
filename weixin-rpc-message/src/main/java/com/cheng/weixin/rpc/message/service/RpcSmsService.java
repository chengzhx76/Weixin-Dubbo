package com.cheng.weixin.rpc.message.service;


import com.cheng.weixin.rabbitmq.model.SmsModel;
import com.cheng.weixin.rpc.message.entity.SmsHistory;
import com.cheng.weixin.rpc.message.enums.MsgType;

/**
 * Desc: 短信服务
 * Author: 光灿
 * Date: 2016/7/10
 */
public interface RpcSmsService {
    /**
     * 获取当天发送短信的个数
     * @param phone
     * @return
     */
    int getCountByDay(String phone);

    /**
     * 获取当前IP发送短信的个数
     * @param ip
     * @return
     */
    int getCountByIp(String ip);

    /**
     * 发送注册短信
     */
    void sendValidate(SmsModel smsModel);

    /**
     * 获取记录根据手机号和类型
     * @param phone
     * @param type
     * @return
     */
    SmsHistory getInfoByPhoneAndType(String phone, MsgType type);

    /**
     * 发送通知短信
     * @param msgData
     */
    void sendNotice(String msgData);

    /**
     * 发送活动短信
     * @param msgData
     */
    void sendActivity(String msgData);

}
