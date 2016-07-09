package com.cheng.weixin.rpc.message.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rpc.message.entity.EnumType.MsgType;

/**
 * Desc: 短信模版
 * Author: cheng
 * Date: 2016/6/21
 */
public class SmsTemplate extends DataEntity<SmsTemplate> {
    private MsgType type;
    private String content;
    private boolean isEnable;

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public SmsTemplate setContent(String content) {
        this.content = content;
        return this;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public SmsTemplate setEnable(boolean enable) {
        isEnable = enable;
        return this;
    }
}