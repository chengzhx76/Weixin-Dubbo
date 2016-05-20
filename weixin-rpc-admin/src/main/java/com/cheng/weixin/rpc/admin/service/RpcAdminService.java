package com.cheng.weixin.rpc.admin.service;


import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.rpc.admin.entity.Permission;
import com.cheng.weixin.rpc.admin.entity.Role;

import java.util.List;

/**
 * Desc: 用户业务处理
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
public interface RpcAdminService {

    Admin getAdminById(String id);
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);

    /**
     * 获取所有的用户
     * @return
     */
    List<Admin> findAdminAll();

    /**
     * 更新管理员登录信息
     * @param admin
     */
    void updateAdminLoginInfo(Admin admin);

    /**
     * 更新管理员信息
     * @param admin
     */
    void updateAdminInfo(Admin admin);

    /**
     * 根据管理员ID更新密码
     * @param id
     */
    void updatePasswdById(String id, String newPasswd);

    /**
     * 获取全部的角色
     * @return
     */
    List<Role> getAllRoles();

    /**
     * 根据管理员ID获取所有的角色
     * @param aid
     * @return
     */
    List<Role> getRolesByAdminId(String aid);

    /**
     * 获取全部的权限
     * @return
     */
    List<Permission> getAllPermissions();

    /**
     * 根据管理员ID获取当前管理员的所有权限
     * @param aid
     * @return
     */
    List<Permission> getPermissionByAdminId(String aid);

}
