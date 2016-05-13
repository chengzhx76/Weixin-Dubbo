package com.cheng.weixin.rpc.admin.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 权限实体类
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public class Permission extends DataEntity<Permission> {
    private String parentId;     // 父资源ID
    private String resourceUrl;  // 链接
    private int priority;        // 优先权排序
    private String name;         // 资源名
    private String precode;      // 权限代码

    public String getParentId() {
        return parentId;
    }

    public Permission setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public Permission setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public Permission setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecode() {
        return precode;
    }

    public void setPrecode(String precode) {
        this.precode = precode;
    }
}
