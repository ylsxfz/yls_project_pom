package com.authority.manager.cluster.es.utills;

import com.authority.manager.vo.LoginBean;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/6/5 14:41
 * @Description: 解析字段的类型，es查询时会使用
 * @Version 1.0
 */
public class MailFieldTypeUtils {

    private static  Map<String,String> whitespaceMap = new HashMap<>();

    private static  Map<String,String> dateMap = new HashMap<>();

    private static  Map<String,String> booleanMap = new HashMap<>();

    private static Map<String,String> numberMap = new HashMap<>();

    private static  Map<String,String> filedMap = new HashMap<>();

    static {
        LoginBean loginBean = new LoginBean();
        Class<? extends LoginBean> aClass = loginBean.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field: declaredFields) {
            String name = field.getName();
            Class<?> type = field.getType();
            if (type == String.class){
                if (!"caseId".equals(name)){
                    whitespaceMap.put(name,"");
                }else {
                    filedMap.put(name,"");
                }

            }else if (type == boolean.class || type == Boolean.class){
                booleanMap.put(name,"");
            }else if(type == Date.class){
                dateMap.put(name,"");
            }else if (type == long.class || type == Long.class
                    || type == int.class || type == Integer.class
                    || type == float.class || type == Float.class){
                numberMap.put(name,"");
            }

        }
    }



    public static Map<String, String> getWhitespaceMap() {
        return whitespaceMap;
    }

    public static Map<String, String> getDateMap() {
        return dateMap;
    }

    public static Map<String, String> getBooleanMap() {
        return booleanMap;
    }

    public static Map<String, String> getNumberMap() {
        return numberMap;
    }

    public static Map<String, String> getFiledMap() {
        return filedMap;
    }
}
