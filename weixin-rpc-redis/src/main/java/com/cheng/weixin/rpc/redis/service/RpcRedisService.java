package com.cheng.weixin.rpc.redis.service;

/**
 * Desc: redis接口服务
 * Author: Cheng
 * Date: 2016/4/21 0021
 */
public interface RpcRedisService {

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    String set(final String key, final String value);

    /**
     * 设置值和过期时间
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    String set(final String key, final String value, final Integer seconds);

    /**
     * 设置单独的生存时间
     * @param key
     * @param seconds
     * @return
     */
    Long expire(final String key, final Integer seconds);
    /**
     * 获取值
     * @param key
     * @return
     */
    String get(final String key);

    /**
     * 删除值
     * @param key
     * @return
     */
    Long del(final String key);
}
