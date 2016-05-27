package com.cheng.weixin.rpc.admin.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public class Role extends DataEntity<Role> {
    /** 角色名字 **/
    private String name;

    private String enname; // 英文名字，也是角色

    private Admin admin;   // 当前用户的角色

    public Role() {
    }

    public Role(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public Role setEnname(String enname) {
        this.enname = enname;
        return this;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Role setAdmin(Admin admin) {
        this.admin = admin;
        return this;
    }
}
