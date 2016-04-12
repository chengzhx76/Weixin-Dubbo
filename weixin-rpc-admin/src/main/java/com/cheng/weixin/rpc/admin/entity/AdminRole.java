package com.cheng.weixin.rpc.admin.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 用户与角色对应关系
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public class AdminRole extends DataEntity<AdminRole> {
    /** 用户ID **/
    private int userId;
    /** 角色ID **/
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
