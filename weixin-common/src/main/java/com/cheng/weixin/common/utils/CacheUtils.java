package com.cheng.weixin.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Desc: 缓存工具类
 * Author: Cheng
 * Date: 2016/2/1 0001
 */
public class CacheUtils {

    private static CacheManager cacheManager = SpringContextHolder.getBean("cacheManagerFactory");

    /** 系统缓存 **/
    private static final String SYS_CACHE="sysCache";

    /**
     * 获取系统缓存
     * @param key
     * @return
     */
    public static Object getSysCache(String key) {
        return get(SYS_CACHE, key);
    }

    /**
     * 写入系统缓存
     * @param key
     * @param value
     */
    public static void putSysCache(String key, Object value) {
        put(SYS_CACHE, key, value);
    }

    /**
     * 移除系统缓存
     * @param key
     */
    public static void removeSysCache(String key) {
        remove(SYS_CACHE, key);
    }
    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (cache != null) {
            Element element = cache.get(key);
            return element == null ? null : element.getObjectValue();
        }
        return cache;

    }

    /**
     * 写入缓存
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        Element element = new Element(key, value);
        getCache(cacheName).put(element);
    }

    /**
     * 移除缓存
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }
    /**
     * 获取一个Cache如果没有则创建一个
     * @param cacheName
     * @return
     */
    private static Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (null==cache) {
            cacheManager.addCache(cacheName);
        }
        return cache;
    }
}
