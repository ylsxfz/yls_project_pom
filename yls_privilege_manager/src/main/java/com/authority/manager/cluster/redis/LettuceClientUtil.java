package com.authority.manager.cluster.redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component("redisUtil")
public class LettuceClientUtil<K,T> {

    @Autowired
    private RedisTemplate  redisTemplate;


    /**
     * 功能描述:
     * 〈指定key的失效时间，按second（秒）计算〉
     *
     * @author : yls
     * @date : 2020/6/8 14:14
     * @param key 键
     * @param time 时间（秒）
     * @return : boolean
     */
    public boolean expire(String key,long time){
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

 
    /**
     * @Description 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, T value) {
        boolean result = false;
        try {
            ValueOperations<String, T> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    /**
     * @Description 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, T value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, T> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    /**
     * @Description 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }
 
    /**
     * @Description 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
 
    /**
     * @Description 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
 
    /**
     * @Description 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
 
    /**
     * @Description 读取缓存
     * @param key
     * @return
     */
    public T get(final String key) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }
 
    /**
     * @Description 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }


    public void hmSet(String key,Map<K,T> map){
        redisTemplate.opsForHash().putAll(key,map);
    }


    /**
     * @Description 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGetValue(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    public Map<K,T> hmGet(String key){
        return (Map<K,T>)redisTemplate.opsForHash().entries(key);
    }
 
    /**
     * @Description 列表添加
     * @param k
     * @param v
     */
    public void lPush(String k, T v) {
        ListOperations<String, T> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }
 
    /**
     * @Description 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<T> lRange(String k, long l, long l1) {
        ListOperations<String, T> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }
 
    /**
     * @Description  集合添加
     * @param key
     * @param value
     */
    public void add(String key, T value) {
        SetOperations<String, T> set = redisTemplate.opsForSet();
        set.add(key, value);
    }
 
    /**
     * @Description 集合获取
     * @param key
     * @return
     */
    public Set<T> setMembers(String key) {
        SetOperations<String, T> set = redisTemplate.opsForSet();
        return set.members(key);
    }
 
    /**
     * @Description 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key, T value, double scoure) {
        ZSetOperations<String, T> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }
 
    /**
     * @Description 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<T> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, T> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }
}
