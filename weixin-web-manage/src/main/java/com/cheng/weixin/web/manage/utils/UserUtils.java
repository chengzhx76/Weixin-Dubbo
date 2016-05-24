package com.cheng.weixin.web.manage.utils;

import com.cheng.weixin.commom.utils.CacheUtils;
import com.cheng.weixin.commom.utils.SpringContextHolder;
import com.cheng.weixin.rpc.admin.entity.Admin;
import com.cheng.weixin.rpc.admin.entity.Permission;
import com.cheng.weixin.rpc.admin.entity.Role;
import com.cheng.weixin.rpc.admin.service.RpcAdminService;
import com.cheng.weixin.web.manage.security.SystemAuthorizingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Desc: 用户工具
 * Author: Cheng
 * Date: 2016/2/1 0001
 */
public class UserUtils {

    private static RpcAdminService adminService = SpringContextHolder.getBean(RpcAdminService.class);

    private static final String ADMIN_CACHE = "adminCache";
    private static final String ADMIN_CACHE_ID_ = "id_";
    private static final String ADMIN_LOGIN_NAME_ = "login_name_";

    private static final String CACHE_ROLE_LIST = "roleList";
    private static final String CACHE_PERMISSION_LIST = "permissionList";

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
            admin.setRoles(adminService.getRolesByAdminId(admin.getId()));
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
    public static Admin getAdminByUsername(String username) {
        Admin admin = (Admin) CacheUtils.get(ADMIN_CACHE, ADMIN_LOGIN_NAME_ + username);
        if (admin == null) {
            admin = adminService.getAdminByUsername(username);
            if (admin == null) {
                return null;
            }
            admin.setRoles(adminService.getRolesByAdminId(admin.getId()));
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

    public static void clearCache() {
        removeCache(CACHE_PERMISSION_LIST);
        removeCache(CACHE_ROLE_LIST);
        clearCache(getUser());
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
     * 获取管理员角色
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Role> getRoles() {
        List<Role> roles = (List<Role>) getCache(CACHE_ROLE_LIST);
        if (roles == null) {
            Admin admin = getUser();
            if (admin.isSuperAdmin()) {
                // 获取全部资源角色
                roles = adminService.getAllRoles();
            } else {
                // 获取当前管理员的所属角色
                roles = adminService.getRolesByAdminId(admin.getId());
            }
            putCache(CACHE_ROLE_LIST, roles);
        }
        return roles;
    }

    /**
     * 获取管理员资源权限
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Permission> getPermissions() {
        List<Permission> permissions = (List<Permission>) getCache(CACHE_PERMISSION_LIST);
        if (permissions == null) {
            Admin admin = getUser();
            if (admin.isSuperAdmin()) {
                // 获取全部资源权限
                permissions = adminService.getAllPermissions();
            } else {
                // 获取当前管理员的所属权限
                permissions = adminService.getPermissionByAdminId(admin.getId());
            }
            putCache(CACHE_PERMISSION_LIST, permissions);
        }
        return permissions;
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

    // =====================用户缓存（对于经常变动的缓存放到Session里，用户退出后缓存丢失）================
    /**
     * 根据Key获取缓存的数据
     * @param key
     * @return
     */
    public static Object getCache(String key) {
        return getCache(key, null);
    }

    /**
     * 根据Key获取缓存的数据，如果没有则返回默认值
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object getCache(String key, Object defaultValue) {
        Object obj = getSession().getAttribute(key);
        return obj == null ? defaultValue : obj;
    }

    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 根据Key移除缓存
     * @param key
     */
    public static void removeCache(String key) {
        getSession().removeAttribute(key);
    }

}
