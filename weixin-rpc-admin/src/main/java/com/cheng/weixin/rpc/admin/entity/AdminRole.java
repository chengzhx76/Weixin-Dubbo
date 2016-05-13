package com.cheng.weixin.rpc.admin.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 用户与角色对应关系
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public class AdminRole extends DataEntity<AdminRole> {
    /** 用户ID **/
    private String userId;
    /** 角色ID **/
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
