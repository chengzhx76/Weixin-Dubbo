package com.cheng.weixin.service.admin.service;

import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.rpc.admin.entity.AdminRole;
import com.cheng.weixin.rpc.admin.entity.Permission;
import com.cheng.weixin.rpc.admin.entity.Role;
import com.cheng.weixin.rpc.admin.model.Page;
import com.cheng.weixin.rpc.admin.service.RpcAdminService;
import com.cheng.weixin.service.admin.dao.AdminDaoMapper;
import com.cheng.weixin.service.admin.dao.AdminRoleDaoMapper;
import com.cheng.weixin.service.admin.dao.PermissionDaoMapper;
import com.cheng.weixin.service.admin.dao.RoleDaoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
    private AdminDaoMapper adminDao;
    @Autowired
    private PermissionDaoMapper permissionDao;
    @Autowired
    private RoleDaoMapper roleDao;
    @Autowired
    private AdminRoleDaoMapper adminRoleDao;

    @Override
    public void add(Admin admin) {
        adminDao.save(admin);
        List<Role> roles = admin.getRoles();
        List<AdminRole> adminRoles = new ArrayList<>();
        for (Role role : roles) {
            if (roleDao.load(new Role(role.getId())) == null) {
                throw new IllegalArgumentException("没有该角色！"+role.getId());
            }
            adminRoles.add(new AdminRole(admin.getId(), role.getId()));
        }
        adminRoleDao.saves(adminRoles);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        Admin admin = adminDao.load(new Admin(null, username));
        return admin;
    }

    @Override
    public List<Admin> getAdminAll() {
        return adminDao.loadAll();
    }

    @Override
    public Page<Admin> findAdminAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminDao.loadAll();

        try {
            PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
            Page<Admin> adminPage = new Page<>();
            BeanUtils.copyProperties(adminPage, adminPageInfo);
            return adminPage;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
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

    @Override
    public List<Role> getAllRoles() {
        return roleDao.loadAll();
    }

    @Override
    public List<Role> getRolesByAdminId(String aid) {
        return roleDao.loadByAdminId(aid);
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionDao.loadAll();
    }
    @Override
    public List<Permission> getPermissionByAdminId(String aid) {
        return permissionDao.loadByAdminId(aid);
    }


}
