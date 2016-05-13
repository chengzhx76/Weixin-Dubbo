package com.cheng.weixin.rpc.admin.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 角色和权限对应关系
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public class RolePermission extends DataEntity<RolePermission> {
    /** 角色ID **/
    private String roleId;
    /** 权限ID **/
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
