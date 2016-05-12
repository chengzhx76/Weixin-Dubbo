package com.cheng.weixin.web.manage.utils;

import com.cheng.weixin.commom.utils.CacheUtils;
import com.cheng.weixin.commom.utils.SpringContextHolder;
import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.rpc.admin.service.RpcAdminService;
import com.cheng.weixin.web.manage.security.SystemAuthorizingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Desc: 用户工具
 * Author: Cheng
 * Date: 2016/2/1 0001
 */
public class UserUtils {

    private static RpcAdminService adminService = SpringContextHolder.getBean(RpcAdminService.class);

    public static final String ADMIN_CACHE = "adminCache";
    public static final String ADMIN_CACHE_ID_ = "id_";
    public static final String ADMIN_LOGIN_NAME_ = "login_name_";

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户对象
     */
    public static Admin get(String id) {
        Admin admin = (Admin) CacheUtils.get(ADMIN_CACHE, ADMIN_CACHE_ID_ + id);
        if (admin == null) {
            admin = adminService.getAdminById(id);
            if (admin == null) {
                return null;
            }
            CacheUtils.put(ADMIN_CACHE, ADMIN_LOGIN_NAME_+admin.getId(), admin);
            CacheUtils.put(ADMIN_CACHE, ADMIN_CACHE_ID_+admin.getUsername(), admin);
        }
        return admin;
    }

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户对象
     */
    public static Admin getByUsername(String username) {
        Admin admin = (Admin) CacheUtils.get(ADMIN_CACHE, ADMIN_LOGIN_NAME_ + username);
        if (admin == null) {
            admin = adminService.getAdminByUsername(username);
            if (admin == null) {
                return null;
            }
            CacheUtils.put(ADMIN_CACHE, ADMIN_LOGIN_NAME_+admin.getId(), admin);
            CacheUtils.put(ADMIN_CACHE, ADMIN_CACHE_ID_+admin.getUsername(), admin);
        }
        return admin;
    }

    /**
     * 清除指定用户缓存
     * @param admin 用户对象
     */
    public static void clearCache(Admin admin) {
        CacheUtils.remove(ADMIN_CACHE, ADMIN_CACHE_ID_+admin.getId());
        CacheUtils.remove(ADMIN_CACHE, ADMIN_LOGIN_NAME_+admin.getUsername());
    }

    /**
     * 获取当前用户
     * @return
     */
    public static Admin getUser() {
        SystemAuthorizingRealm.Principal principal = getPrincipal();
        if (principal != null) {
            Admin admin = get(principal.getId());
            if (admin != null) {
                return admin;
            }
        }
        return new Admin();
    }

    /**
     * 获取当前登陆者对象
     * @return
     */
    public static SystemAuthorizingRealm.Principal getPrincipal() {
        Subject subject = SecurityUtils.getSubject();
        SystemAuthorizingRealm.Principal principal = (SystemAuthorizingRealm.Principal) subject.getPrincipal();
        if (principal != null) {
            return principal;
        }
        return null;
    }

    /**
     * 获得当前用户的Session
     * @return
     */
    public static Session getSession() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession(false);
        if (null == session) {
            session = currentUser.getSession();
        }
        return session;
    }
}
