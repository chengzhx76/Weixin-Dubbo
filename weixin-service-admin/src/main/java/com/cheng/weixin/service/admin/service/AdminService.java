package com.cheng.weixin.service.admin.service;

import com.cheng.weixin.service.admin.dao.AdminDaoMapper;
import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.rpc.admin.service.RpcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Desc: 用户业务类
 * Author: Cheng
 * Date: 2016/1/28 0028
 */
@Service("adminService")
public class AdminService implements RpcAdminService {

    @Autowired
    public AdminDaoMapper adminDao;
    @Override
    public Admin getAdminByUsername(String username) {
        return adminDao.load(new Admin(null, username));
    }

    @Override
    public List<Admin> findAdminAll() {
        return adminDao.loadAll();
    }

    @Override
    public Admin getAdminById(String id) {
        return adminDao.load(new Admin(id, null));
    }

    @Override
    public void updateAdminLoginInfo(Admin admin) {
        Admin update = new Admin();
        update.setId(admin.getId());
        // 更新上次登录信息

        if(admin.getLoginIp() != null) update.setOldLoginIp(admin.getLoginIp());
        if(admin.getLoginDate() != null) update.setOldLoginDate(admin.getLoginDate());
        // 更新这次登录信息
        update.setLoginIp(admin.getNewLoginIp());
        update.setLoginDate(new Date());
        update.preUpdate();
        adminDao.update(update);
    }

    @Override
    public void updateAdminInfo(Admin admin) {
        admin.preUpdate();
        adminDao.update(admin);
    }

    @Override
    public void updatePasswdById(String id, String newPasswd) {
        Admin updatePwd = new Admin();
        updatePwd.setId(id);
        updatePwd.setPassword(newPasswd);
        updatePwd.preUpdate();
        adminDao.update(updatePwd);
    }
}
