package com.cheng.weixin.common.redis.service;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/4/14 0014
 */
public interface Function<T, E> {
    T callback(E e);
}
