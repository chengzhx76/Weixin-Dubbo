package com.cheng.weixin.rpc.redis.service;

/**
 * Desc: redis接口服务
 * Author: Cheng
 * Date: 2016/4/21 0021
 */
public interface RpcRedisService {

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    void remove(final String... keys);

    /**
     * 批量删除key
     *
     * @param pattern
     */
    void removePattern(final String pattern);

    /**
     * 删除对应的value
     *
     * @param key
     */
    void remove(final String key);

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    boolean exists(final String key);

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    Object get(final String key);

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(final String key, Object value);

    /**
     * 写入缓存 并设置过期时间
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    boolean set(final String key, Object value, Long expireTime);
    /**
     * 根据Key刷新超时时间
     * @param key
     * @param expireTime
     * @return
     */
    boolean flushExpireTime(final String key, Long expireTime);
}
