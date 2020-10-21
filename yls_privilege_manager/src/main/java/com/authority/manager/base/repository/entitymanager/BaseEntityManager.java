package com.authority.manager.base.repository.entitymanager;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/24 17:20
 * @Description
 * @Version 1.0
 **/
public interface BaseEntityManager<T, ID> {
    /**
     * @param entity 保存的实体
     * @return java.lang.Boolean
     * @Author yls
     * @Description 保存实体
     * @Date 2020/3/22 11:19
     **/
    Boolean saveEntity(T entity);


    /**
     * @param clazz 实体类
     * @param id    id主键
     * @return T
     * @Author yls
     * @Description 根据id查询
     * @Date 2020/3/22 11:26
     **/
    T findByID(Class<T> clazz, ID id);

    /**
     * @param clazz  类
     * @param field  字段名
     * @param value 字段参数
     * @return java.util.List<T>
     * @Author yls
     * @Description 根据字段查询数据
     * @Date 2020/3/22 11:17
     **/
    List<T> findByField(Class<T> clazz, String field, Object value);

    /**
     * @param entity 实体对象
     * @return java.lang.Boolean
     * @Author yls
     * @Description 根据表的id删除数据
     * @Date 2020/3/22 11:29
     **/
    Boolean deleteEntity(T entity);

    /**
     * @param entity 实体对象
     * @return java.lang.Boolean
     * @Author yls
     * @Description 更新实体对象
     * @Date 2020/3/22 11:30
     **/
    Boolean update(T entity);

    /**
     * @param clazz 实体类
     * @param id    id主键
     * @return java.lang.Boolean
     * @Author yls
     * @Description 根据id删除
     * @Date 2020/3/22 11:36
     **/
    Boolean deleteById(Class<T> clazz, ID id);

    /**
     * @param clazz 实体类
     * @param ids   id集合
     * @return java.lang.Boolean
     * @Author yls
     * @Description 根据id集合批量删除
     * @Date 2020/3/22 11:37
     **/
    Boolean deleteByIds(Class<T> clazz, List<ID> ids);

}
