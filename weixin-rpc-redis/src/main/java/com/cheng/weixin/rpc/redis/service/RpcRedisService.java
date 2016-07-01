package com.cheng.weixin.rpc.redis.service;

import java.util.Set;

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

    // ================================Hash 操作=================================
    /**
     * 数量递增
     * @param key
     * @param field
     */
    Long increase(String key, String field);
    /**
     * 数量递减
     * @param key
     * @param field
     */
    Long decrease(String key, String field);

    /**
     * 删除一个Field
     * @param key
     * @param field
     */
    void deleteField(String key, String field);

    /**
     * 根据key获取所有的Field
     * @param key
     * @return
     */
    Set<String> getFields(String key);

    /**
     * 查看该字段是否已有
     * @param key
     * @param field
     * @return
     */
    boolean exists(String key, String field);

}
