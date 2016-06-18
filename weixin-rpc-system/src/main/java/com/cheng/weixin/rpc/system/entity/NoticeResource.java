package com.cheng.weixin.rpc.system.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 图片资源
 * Author: 光灿
 * Date: 2016/6/18
 */
public class NoticeResource extends DataEntity<NoticeResourceType> {
    private String noticeTesourceTypeId;
    private String title;
    private String content;
    private String href;

    public String getNoticeTesourceTypeId() {
        return noticeTesourceTypeId;
    }

    public NoticeResource setNoticeTesourceTypeId(String noticeTesourceTypeId) {
        this.noticeTesourceTypeId = noticeTesourceTypeId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NoticeResource setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NoticeResource setContent(String content) {
        this.content = content;
        return this;
    }

    public String getHref() {
        return href;
    }

    public NoticeResource setHref(String href) {
        this.href = href;
        return this;
    }
}
