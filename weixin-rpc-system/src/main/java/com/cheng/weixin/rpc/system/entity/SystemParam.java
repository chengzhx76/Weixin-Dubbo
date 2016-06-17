package com.cheng.weixin.rpc.system.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc:系统参数
 * Author: 光灿
 * Date: 2016/6/17
 */
public class SystemParam extends DataEntity<SystemParam> {
    private String name;
    private String title;
    private String logo;
    private String description;
    private String copyright;
    private boolean isEnable;

    public String getName() {
        return name;
    }

    public SystemParam setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SystemParam setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public SystemParam setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SystemParam setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public SystemParam setCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public SystemParam setEnable(boolean enable) {
        isEnable = enable;
        return this;
    }
}
