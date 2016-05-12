package com.cheng.weixin.rpc.admin.service;


import com.cheng.weixin.rpc.admin.entity.Admin;

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

}
