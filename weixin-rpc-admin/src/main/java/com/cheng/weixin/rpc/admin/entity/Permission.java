package com.cheng.weixin.rpc.admin.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 权限实体类
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public class Permission extends DataEntity<Permission> {
    private String name;         // 资源名
    private String precode;      // 权限代码

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
