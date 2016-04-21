package com.cheng.weixin.service.redis.service;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/4/14 0014
 */
public interface Function<T, E> {
    T callback(E e);
}
