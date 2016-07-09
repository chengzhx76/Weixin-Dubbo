package com.cheng.weixin.rpc.message.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 邮件模板
 * Author: 光灿
 * Date: 2016/6/17
 */
public class EmailTemplate extends DataEntity<EmailTemplate> {
    private String name;
    private String title;
    private String content;
    private boolean isEnable;

    public String getName() {
        return name;
    }

    public EmailTemplate setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EmailTemplate setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EmailTemplate setContent(String content) {
        this.content = content;
        return this;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public EmailTemplate setEnable(boolean enable) {
        isEnable = enable;
        return this;
    }
}
