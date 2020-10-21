package com.authority.manager.base.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Auther: yls
 * @Date: 2020/10/14 9:51
 * @Description: json工具类
 * @Version 1.0
 */
public class JsonUtils {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 功能描述:
     * 〈将对象装换为json字符串〉
     *
     * @author : yls
     * @date : 2020/10/14 9:54
     * @param data
     * @return : java.lang.String
     */
    public static String objectToJson(Object data){
        try {
            String str = MAPPER.writeValueAsString(data);
            return StringUtils.isEmpty(str) ? "" : str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 功能描述:
     * 〈将json结果集转化为对象〉
     *
     * @author : yls
     * @date : 2020/10/14 10:01
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return : T 泛型，对应转换的实体类
     */
    public static <T> T jsonToPojo(String jsonData,Class<T> beanType){
        try {
            return MAPPER.readValue(jsonData,beanType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述:
     * 〈将json转换为pojo对象list〉
     *
     * @author : yls
     * @date : 2020/10/14 10:04
     * @param jsonData json数据
     * @param beanType 实体对象
     * @return : java.util.List<T>
     */
    public static <T> List<T> jsonToList(String jsonData,Class<T> beanType){
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
            return MAPPER.readValue(jsonData,javaType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
