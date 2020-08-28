package com.authority.manager.cluster.redis;

import com.authority.manager.contant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 *
 * @param <K> 泛型K
 * @param <T> 泛型T
 */
@Component("redisUtil")
public class LettuceClientUtil<K, T> {

    @Autowired
    private RedisTemplate redisTemplate;

    /***************************************》common-start《******************************************/
    /**
     * 功能描述:
     * 〈指定key的失效时间，按second（秒）计算〉
     *
     * @param key  键
     * @param time 时间（秒）
     * @return : boolean
     * @author : yls
     * @date : 2020/6/8 14:14
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 功能描述:
     * 〈根据key获取过期的时间〉
     *
     * @param key 键
     * @return : long
     * @author : yls
     * @date : 2020/07/12 14:35
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 功能描述:
     * 〈根据key来判断key是否存在〉
     *
     * @param key 键
     * @return : boolean
     * @author : yls
     * @date : 2020/07/12 14:36
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /***************************************》common-end《******************************************/


    /***************************************》string-start《******************************************/
    /**
     * 功能描述:
     * 〈设置字符串键值对〉
     *
     * @param key   键
     * @param value 值
     * @return : boolean 是否成功
     * @author : yls
     * @date : 2020/07/12 14:32
     */
    public boolean set(final String key, T value) {
        try {
            ValueOperations<String, T> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈写入缓存,并且设置时效时间〉
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间（秒）
     * @return : boolean
     * @author : yls
     * @date : 2020/07/12 14:45
     */
    public boolean set(final String key, T value, Long expireTime) {
        try {
            ValueOperations<String, T> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 功能描述:
     * 〈批量删除对应的value〉
     *
     * @param keys 多个key集合
     * @return : boolean
     * @author : yls
     * @date : 2020/07/12 14:42
     */
    public boolean removeKeys(final List<String> keys) {
        try {
            for (String key : keys) {
                remove(key);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈 批量删除key〉
     *
     * @param pattern
     * @return : boolean
     * @author : yls
     * @date : 2020/07/12 14:46
     */
    public boolean removePattern(final String pattern) {
        try {
            Set<String> keys = redisTemplate.keys(pattern);
            if (keys.size() > 0)
                redisTemplate.delete(keys);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈根据输入的key删除对应的value〉
     *
     * @param key 待删除的key
     * @return : boolean
     * @author : yls
     * @date : 2020/07/12 14:47
     */
    public boolean remove(final String key) {
        try {
            if (hasKey(key)) {
                redisTemplate.delete(key);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 功能描述:
     * 〈根据key获取对应的value〉
     *
     * @param key 键
     * @return : T
     * @author : yls
     * @date : 2020/07/12 14:50
     */
    public T get(final String key) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }


    /**
     * 功能描述:
     * 〈递增〉
     *
     * @param key      键
     * @param incrData 递增值（大于0）
     * @return : long
     * @author : yls
     * @date : 2020/07/12 15:03
     */
    public long incr(String key, long incrData) {
        if (incrData < 0) {
            throw new RuntimeException(String.valueOf(RedisConstant.RedisException.incrException));
        }

        return redisTemplate.opsForValue().increment(key, incrData);
    }


    /**
     * 功能描述:
     * 〈递减〉
     *
     * @param key     键
     * @param descata 递减值（大于0）
     * @return : long
     * @author : yls
     * @date : 2020/07/12 15:03
     */
    public long desc(String key, long descata) {
        if (descata < 0) {
            throw new RuntimeException(String.valueOf(RedisConstant.RedisException.incrException));
        }

        return redisTemplate.opsForValue().increment(key, -descata);
    }

    /***************************************》string-end《******************************************/


    /***************************************》map-start《*********************************************/
    /**
     * 功能描述:
     * 〈hashGet〉
     *
     * @param key  键(不能为null)
     * @param item 项(不能为null)
     * @return : T
     * @author : yls
     * @date : 2020/07/12 15:10
     */
    public T hget(String key, String item) {
        return (T) redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 功能描述:
     * 〈批量查询map〉
     *
     * @param key  map的key
     * @param item field的字段过滤查询
     * @return : java.util.List<T>
     * @author : yls
     * @date : 2020/07/12 15:11
     */
    public List<T> hget(String key, Collection<Object> item) {
        return (List<T>) redisTemplate.opsForHash().multiGet(key, item);
    }

    /**
     * 功能描述:
     * 〈获取hashKey对应的所有键值〉
     *
     * @param key 键
     * @return : java.util.Map<K,T>
     * @author : yls
     * @date : 2020/07/12 15:11
     */
    public Map<K, T> hmget(String key) {
        return (Map<K, T>) redisTemplate.opsForHash().entries(key);
    }

    /**
     * 功能描述:
     * 〈HashSet〉
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<K, T> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈 HashSet 并设置时间〉
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<K, T> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈向一张hash表中放入数据,如果不存在将创建〉
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, T value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈向一张hash表中放入数据,如果不存在将创建〉
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key, String item, T value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈删除hash表中的值〉
     *
     * @param key  键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public boolean hdel(String key, Object... item) {
        try {
            redisTemplate.opsForHash().delete(key, item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈判断hash表中是否有该项的值〉
     *
     * @param key  键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
        try {
            return redisTemplate.opsForHash().hasKey(key, item);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈hash递增 如果不存在,就会创建一个 并把新增后的值返回〉
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * 功能描述:
     * 〈hash递减〉
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /***************************************》map-end《**********************************************/

    /***************************************》set-start《*********************************************/

    /**
     * 功能描述:
     * 〈根据key获取Set中的所有值〉
     *
     * @param key 键
     * @return
     */
    public Set<T> setGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:
     * 〈根据value从一个set中查询,是否存在〉
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean setHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈将数据放入set缓存〉
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    @SuppressWarnings("unchecked")
    public long setAdd(String key, T... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 功能描述:
     * 〈将set数据放入缓存〉
     *
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long setAddAndTime(String key, long time, T... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) expire(key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 功能描述:
     * 〈获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    public long setGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 功能描述:
     * 〈移除值为value的〉
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    /***************************************》set-end《**********************************************/

    /***************************************》list-start《**********************************************/
    /**
     * 功能描述:
     * 〈 获取list缓存的内容〉
     *
     * @param key   键
     * @param start 开始
     * @param end   结束  0 到 -1代表所有值
     * @return
     */
    public List<T> listGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:
     * 〈获取list缓存的长度〉
     *
     * @param key 键
     * @return
     */
    public long listGetSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 功能描述:
     * 〈通过索引 获取list中的值〉
     *
     * @param key   键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public T listGetIndex(String key, long index) {
        try {
            ListOperations<String, T> listOperations = redisTemplate.opsForList();
            return listOperations.index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述:
     * 〈将list放入缓存〉
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean listSet(String key, T value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈将list放入缓存〉
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean listSet(String key, T value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈将list放入缓存〉
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean listSet(String key, List<T> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈将list放入缓存〉
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean listSet(String key, List<T> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈根据索引修改list中的某条数据〉
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean listUpdateIndex(String key, long index, T value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈移除N个值为value〉
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long listRemove(String key, long count, T value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    /***************************************》list-end《**********************************************/


    /***************************************》队列-end《**********************************************/




    /**
     * 功能描述:
     * 〈从右边添加进队列〉
     *
     * @param key   队列名称
     * @param value 数据
     */
    public boolean rightPush(String key, T value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 功能描述:
     * 〈跟rightPush是同样的操作，唯一的不同是，当且仅当key存在时，
     * 才会更新key的值。如果key不存在则不会对数据进行任何操作。〉
     *
     * @param key   队列名称
     * @param value 数据
     */
    public boolean rightPushIfPresent(String key, T value) {
        try {
            redisTemplate.opsForList().rightPushIfPresent(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈从右边添加进队列〉
     *
     * @param key   队列名称
     * @param value 数据
     */
    public boolean rightPushAll(String key,Collection<?> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 功能描述:
     * 〈从右边弹出队列数据〉
     *
     * @param key 队列名称
     * @return
     */
    public T rightPop(String key) {
        ListOperations<String, T> listOperations = redisTemplate.opsForList();
        return listOperations.rightPop(key);
    }

    /**
     * 功能描述:
     * 〈从右边弹出队列数据〉
     *
     * @param key  队里名称
     * @param time 等待时间,如果超过等待时间就退出等待
     * @return
     */
    public T rightPop(String key, long time) {
        ListOperations<String, T> listOperations = redisTemplate.opsForList();
        return listOperations.rightPop(key, time, TimeUnit.SECONDS);
    }



    /**
     * 功能描述:
     * 〈从左边添加进队列〉
     *
     * @param key   队列名称
     * @param value 数据
     */
    public boolean leftPush(String key, T value) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 功能描述:
     * 〈跟leftPush是同样的操作，唯一的不同是，当且仅当key存在时，
     * 才会更新key的值。如果key不存在则不会对数据进行任何操作。〉
     *
     * @param key   队列名称
     * @param value 数据
     */
    public boolean leftPushIfPresent(String key, T value) {
        try {
            redisTemplate.opsForList().leftPushIfPresent(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 功能描述:
     * 〈从左边添加进队列〉
     *
     * @param key   队列名称
     * @param value 数据
     */
    public boolean leftPushAll(String key,Collection<?> value) {
        try {
            redisTemplate.opsForList().leftPushAll(value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述:
     * 〈从左边弹出队列数据〉
     *
     * @param key 队列名称
     * @return
     */
    public T leftPop(String key) {
        ListOperations<String, T> listOperations = redisTemplate.opsForList();
        return listOperations.leftPop(key);
    }

    /**
     * 功能描述:
     * 〈从左边边弹出队列数据〉
     *
     * @param key  队里名称
     * @param time 等待时间,如果超过等待时间就退出等待
     * @return
     */
    public T leftPop(String key, long time) {
        ListOperations<String, T> listOperations = redisTemplate.opsForList();
        return listOperations.leftPop(key, time, TimeUnit.SECONDS);
    }


    /**
     * 功能描述:
     * 〈从一个队列的右边弹出一个元素并将这个元素放入另一个指定队列的最左边
     *  该函数用于操作两个键之间的数据，接受两个参数，分别是源key、目标key。
     *  该函数会将源key进行rightPop，再将返回的值，作为输入参数，
     *  在目标key上进行leftPush。〉
     * @author : yls
     * @date : 2020/07/12 15:47
     * @param sourceKey 原始值
     * @param destionationKey 目标值
     * @return : T
     */
    public T rightPopAndLeftPush(String sourceKey, String destionationKey){
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        return listOperations.rightPopAndLeftPush(sourceKey,destionationKey);
    }

    /**
     * 功能描述:
     * 〈从一个队列的右边弹出一个元素并将这个元素放入另一个指定队列的最左边,
     * 与RightPopAndLeftPush相似，只是添加了超时机制〉
     * @author : yls
     * @date : 2020/07/12 15:47
     * @param sourceKey 原始值
     * @param destionationKey 目标值
     * @param timeout 超时时间
     * @param unit 限制
     * @return : T
     */
    public T rightPopAndLeftPush(String sourceKey, String destionationKey, long timeout, TimeUnit unit){
        ListOperations<String,T> listOperations = redisTemplate.opsForList();
        return listOperations.rightPopAndLeftPush(sourceKey,destionationKey,timeout,unit);
    }

    /***************************************》队列-end《**********************************************/

    /***************************************》有序集合-start《**********************************************/

    /**
     * 功能描述:
     * 〈有序集合添加〉
     *
     * @param key    键
     * @param value  值
     * @param scoure 分数
     */
    public void zAdd(String key, T value, double scoure) {
        ZSetOperations<String, T> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 功能描述:
     * 〈有序集合获取〉
     *
     * @param key   键
     * @param start 最小值
     * @param end   最大值
     * @return
     */
    public Set<T> rangeByScore(String key, double start, double end) {
        ZSetOperations<String, T> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, start, end);
    }
    /***************************************》有序集合-end《**********************************************/
}
