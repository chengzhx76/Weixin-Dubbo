package com.cheng.weixin.service.redis.service;

import com.cheng.weixin.rpc.redis.service.RpcRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Desc: Redis 服务封装
 * Author: Cheng
 * Date: 2016/4/14 0014
 */
@Service("redisService")
public class RedisService implements RpcRedisService {

    @Autowired
    private ShardedJedisPool jedisPool;

    private <T> T execute(Function<T, ShardedJedis> function) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取Jedis分片对象
            shardedJedis = jedisPool.getResource();
            return function.callback(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭，检测连接是否有效，有效则放回连接池中，无效则重置状态
            if (null != shardedJedis) shardedJedis.close();
        }
        return null;
    }

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.set(key, value);
            }
        });
    }

    /**
     * 设置值和过期时间
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set(final String key, final String value, final Integer seconds) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis shardedJedis) {
                String result = shardedJedis.set(key, value);
                shardedJedis.expire(key, seconds);
                return result;
            }
        });
    }

    /**
     * 设置单独的生存时间
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis shardedJedis) {
                return shardedJedis.expire(key, seconds);
            }
        });
    }
    /**
     * 获取值
     * @param key
     * @return
     */
    public String get(final String key) {
        return execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.get(key);
            }
        });
    }

    /**
     * 删除值
     * @param key
     * @return
     */
    public Long del(final String key) {
        return execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis shardedJedis) {
                return shardedJedis.del(key);
            }
        });
    }

}
