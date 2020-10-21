package com.authority.manager.base.repository;

import com.authority.manager.base.jpql.QueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/24 10:23
 * @Description
 * @Version 1.0
 **/
public interface BaseJpaService<T,ID extends Serializable> extends BaseJpaRepository {

    /*************************************************jpql-复杂条件查询-start********************************************************/
    /**
     * @Author yls
     * @Description 复杂的条件查询
     * @Date 2020/3/24 11:11
     * @param queryParams 查询条件组装
     * @return java.util.List<T>
     **/
    default List<T> findByQueryParams(QueryParams queryParams){
        return getDao().findAll(queryParams);
    }


    /**
     * @Author yls
     * @Description 复杂的条件查询
     * @Date 2020/3/24 11:11
     * @param queryParams 查询条件组装
     * @param pageable 分页信息
     * @return org.springframework.data.domain.Page<T>
     **/
    default Page<T> findByQueryParams(QueryParams queryParams, Pageable pageable){
        return getDao().findAll(queryParams,pageable);
    }
    /*************************************************jpql-复杂条件查询-end********************************************************/

}
