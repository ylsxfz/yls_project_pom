package com.authority.manager.base.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @Author yls
 * @Date 2020/3/24 16:41
 * @Description 基础Service
 * @Version 1.0
 **/
public interface BaseJpaRepository<T,ID extends Serializable>{
    @Autowired
    BaseJpaDAO<T, ID> getDao();

    /**********************************查询-Retrieve-start*************************************/
    /**
     * @Description 查询所有数据
     * @Date 2020/3/24 16:48
     * @return java.util.List<T>
     **/
    default List<T> findAll() throws Exception {
        return getDao().findAll();
    }

    /**
     * @Description 按某种排序查询全部数据
     * @Date 2020/3/24 16:50
     * @param sort 排序
     * @return java.util.List<T>
     **/
    default List<T> findAll(Sort sort){
        return getDao().findAll(sort);
    }

    /**
     * @Description 批量id查询
     * @Date 2020/3/24 16:53
     * @param ids 待查询的id集合
     * @return java.util.List<T>
     **/
    default List<T> findByIds(Iterable<ID> ids){
        return getDao().findAllById(ids);
    }

    /**
     * @Description 根据id查询
     * @Date 2020/3/24 16:54
     * @param id 查询的id
     * @return java.util.Optional<T>
     **/
    default Optional<T> findById(ID id){
        return getDao().findById(id);
    }

    /**
     * @Description 分页查询
     * @Date 2020/3/24 17:32
     * @param pageable 分页
     * @return org.springframework.data.domain.Page<T>
     **/
    default Page<T> findByPage(Pageable pageable){
        return getDao().findAll(pageable);
    }

    /**
     * @Author yls
     * @Description 带条件的分页查询
     * @Date 2020/3/24 17:34
     * @param example 分页条件
     * @param pageable 分页
     * @return org.springframework.data.domain.Page<T>
     **/
    default Page<T> findByPage(Example<T> example, Pageable pageable){
        return getDao().findAll(example,pageable);
    }
    /**********************************查询-Retrieve-end*************************************/

    /**********************************保存-Create-start*************************************/

    /**
     * @Description 报错数据
     * @Date 2020/3/24 16:57
     * @param t 实体数据
     * @return T
     **/
    default T save(T t){
        return getDao().save(t);
    }

    default T saveAndFlush(T t){
        return getDao().saveAndFlush(t);
    }

    /**
     * @Description 批量报错数据
     * @Date 2020/3/24 16:59
     * @param varls 保存的数据集合
     * @return java.util.List<T>
     **/
    default List<T> saveAll(Iterable<T> varls){
        List<T> list = getDao().saveAll(varls);
        getDao().flush();
        return list;
    }

    /**********************************保存-Create-end*************************************/


    /**********************************删除-Delete-start*************************************/
    /**
     * @Description 根据id删除数据
     * @Date 2020/3/24 17:01
     * @param id 待删除的数据的id
     * @return java.lang.Boolean
     **/
    default Boolean deleteById(ID id){
        getDao().deleteById(id);
        return true;
    }

    default Boolean deleteAll(List<T> list){
        getDao().deleteAll(list);
        return true;
    }
    /**********************************删除-Delete-end*************************************/

}

