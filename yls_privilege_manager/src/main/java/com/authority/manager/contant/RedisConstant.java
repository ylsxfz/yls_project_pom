package com.authority.manager.contant;

/**
 * @Auther: yls
 * @Date: 2020/7/12 0012 14:53
 * @Description: redis相关的常量类
 * @Version 1.0
 */
public class RedisConstant {
    public enum RedisException{
        incrException("递增因子必须大于0！！！"),
        descException("递减因子必须大于0！！！")
        ;

        private String redisException;

        RedisException(String redisException) {
            this.redisException = redisException;
        }
    }
}
