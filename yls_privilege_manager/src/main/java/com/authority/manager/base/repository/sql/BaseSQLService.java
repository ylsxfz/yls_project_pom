package com.authority.manager.base.repository.sql;


import com.authority.manager.base.jpql.QueryParams;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/24 10:46
 * @Description
 * @Version 1.0
 **/
public interface BaseSQLService<T>{
    /**
     * @Author yls
     * @Description 查询全字段，返回泛型字体类集合
     * @Date 2020/3/24 10:55
     * @param sql 初始sql
     * @param queryParams 查询的参数
     * @param pageable 分页工具
     * @param clazz 泛型的类型
     * @return java.util.List<T>
     **/
    List<T> getResultByAllCols(String sql, QueryParams queryParams, Pageable pageable, Class<?> clazz) throws Exception;

    /**
     * @Author yls
     * @Description 查询全字段，返回泛型字体类集合
     * @Date 2020/3/24 10:55
     * @param sql 初始sql
     * @param queryParams 查询的参数
     * @param pageable 分页工具
     * @return java.util.List
     **/
    List getResultBySomeCols(String sql, QueryParams queryParams, Pageable pageable) throws Exception;

    /**
     * 功能描述:
     * 〈插入日志〉
     * @author : yls
     * @date : 2020/10/21 22:18
     * @param sql
     * @return : void
     */
    void insertLogByDay(String sql) throws Exception;
}
