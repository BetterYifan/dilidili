package com.dilidili.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 指定缓存失效时间
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("redis.execute error: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 删除key
     */
    public Long delete(String... keys) {
        if (Objects.isNull(keys) || keys.length < 1) {
            return 0L;
        }
        return redisTemplate.delete(Arrays.asList(keys));
    }

//    =================String===================

    /**
     * 普通缓存(K,V)获取
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 放入普通缓存
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("redis.execute error: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 放入普通缓存(带过期时间)
     */
    public boolean setWithExpire(String key, Object value, long time) {
        try {
            if (time > 0) {
                set(key, value);
            } else {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("redis.execute error: {}", e.getMessage());
            return false;
        }
    }

//    =============Map===========

    /**
     * HashGet
     */
    public Object hget(String key, String hashKey) {
        if (Objects.isNull(key) || Objects.isNull(hashKey)) {
            return null;
        }
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 单个元素hashset
     *
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public boolean hset(String key, String hashKey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 写入hash
     *
     * @param key
     * @param hashKey
     * @param value
     * @param expire  如果key已存在，则会替换原有时间
     * @return
     */
    public boolean hsetWithExpire(String key, String hashKey, Object value, long expire) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            if (expire > 0) {
                expire(key, expire);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取key下的所有hashKey值
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     *
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error("redis.execute: {}", e.getMessage());
            return false;
        }
    }
}
