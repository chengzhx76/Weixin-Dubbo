package com.cheng.weixin.rpc.system.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/21
 */
public class SmsTemplate extends DataEntity<SmsTemplate> {
    private String name;
    private String content;
    private boolean isEnable;

    public String getName() {
        return name;
    }

    public SmsTemplate setName(String name) {
        this.name = name;
        return this;
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