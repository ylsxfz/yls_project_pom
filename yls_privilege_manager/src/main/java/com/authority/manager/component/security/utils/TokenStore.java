package com.authority.manager.component.security.utils;

import com.authority.manager.component.security.JwtAuthenticatioToken;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: yls
 * @Date: 2020/10/12 13:03
 * @Description: 存储token的信息
 * @Version 1.0
 */
public class TokenStore {

    /**
     * 存储token信息
     */
    private static final ConcurrentHashMap<String,String> tokenMap = new ConcurrentHashMap<>();

    /**
     * 存储用户的登录过期时间
     */
    private static final ConcurrentHashMap<String,Long> expMap = new ConcurrentHashMap<>();


    /**
     * 存储用户的登录过期时间
     */
    private static final ConcurrentHashMap<String, JwtAuthenticatioToken> authMap = new ConcurrentHashMap<>();


    protected static void addJwtAuthenticatioToken(String name,JwtAuthenticatioToken jwtAuthenticatioToken){
        authMap.put(name,jwtAuthenticatioToken);
    }

    protected static JwtAuthenticatioToken getJwtAuthenticatioToken(String name){
       return authMap.get(name);
    }

    /**
     * 功能描述:
     * 〈添加token信息〉
     *
     * @author : yls
     * @date : 2020/10/12 13:07
     * @param name 姓名（必须保证用户名唯一）
     * @param token token令牌信息
     * @param date 过期时间
     * @return : void
     */
    protected static void addToken(String name,String token,Long date){
        tokenMap.put(name,token);
        expMap.put(name,date);
    }

    /**
     * 功能描述:
     * 〈通过用户名获取token〉
     *
     * @author : yls
     * @date : 2020/10/12 13:09
     * @param name 用户名
     * @return : java.lang.String
     */
    protected static String getToken(String name){
        return tokenMap.get(name);
    }

    /**
     * 功能描述:
     * 〈检查token是否过期〉
     *
     * @author : yls
     * @date : 2020/10/12 13:14
     * @param name 用户名
     * @return : boolean true: 已过期  false：未过期
     */
    protected static boolean checkTokenExp(String name){
        if (expMap.containsKey(name)){
            boolean isExp = expMap.get(name) < System.currentTimeMillis();
            if (isExp){
                removeToken(name);
            }
            return isExp;
        }
        return true;
    }


    /**
     * 功能描述:
     * 〈强制删除token信息〉
     *
     * @author : yls
     * @date : 2020/10/12 13:10
     * @param name 用户名
     * @return : void
     */
    protected static void removeToken(String name){
        tokenMap.remove(name);
        expMap.remove(name);
    }
}
