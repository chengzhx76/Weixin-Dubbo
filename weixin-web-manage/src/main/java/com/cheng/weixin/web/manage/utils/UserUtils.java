package com.cheng.weixin.web.manage.utils;

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
    /**
     * 获取当前登陆者对象
     * @return
     */
    public static SystemAuthorizingRealm.Principal getPrincipal() {
        Subject subject = SecurityUtils.getSubject();
        SystemAuthorizingRealm.Principal principal = (SystemAuthorizingRealm.Principal) subject.getPrincipal();
        if (principal!=null) {
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
