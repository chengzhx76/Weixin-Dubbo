package com.cheng.weixin.rpc.message.entity;

import com.cheng.common.entity.DataEntity;
import com.cheng.weixin.rabbitmq.enums.MsgType;

/**
 * Desc: 邮件模板
 * Author: 光灿
 * Date: 2016/6/17
 */
public class EmailTemplate extends DataEntity<EmailTemplate> {
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
