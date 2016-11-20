package com.cheng.weixin.rpc.message.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rabbitmq.enums.MsgType;

/**
 * Desc: 短信模版
 * Author: cheng
 * Date: 2016/6/21
 */
public class SmsTemplate extends DataEntity<SmsTemplate> {
    private MsgType type;
    private String content;
    private int timeout;
    private boolean isEnable;

    public SmsTemplate() {
    }

    public SmsTemplate(MsgType type) {
        this.type = type;
        this.isEnable = true;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}