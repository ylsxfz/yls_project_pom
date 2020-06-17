package com.yls.core.repository.sql;


import com.yls.core.jpql.QueryParams;
import com.yls.core.sql.NativeSQL;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/24 10:47
 * @Description
 * @Version 1.0
 **/
@Service
public class BaseSQLServiceImpl<T> extends NativeSQL implements BaseSQLService<T> {

    @Autowired
    private EntityManager entityManager;

    /**
     * @Author yls
     * @Description 查询全字段，返回泛型字体类集合
     * @Date 2020/3/24 10:55
     * @param sql 初始sql
     * @param queryParams 查询的参数
     * @param pageable 分页工具
     * @return java.util.List
     **/
    @Override
    public List<T> getResultByAllCols(String sql, QueryParams queryParams, Pageable pageable, Class<?> clazz) {
        Query query = getBaseQuery(sql, queryParams, pageable);
        //hibernate 5.2 后已作废
        //query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);;
        //改为
        query.unwrap(NativeQuery.class).addEntity(clazz);
        List resultList = query.getResultList();
        return resultList;
    }

    /**
     * @Author yls
     * @Description 查询全字段，返回泛型字体类集合
     * @Date 2020/3/24 10:55
     * @param sql 初始sql
     * @param queryParams 查询的参数
     * @param pageable 分页工具
     * @return java.util.List<T>
     **/
    @Override
    public List getResultBySomeCols(String sql, QueryParams queryParams, Pageable pageable) {
        Query query = getBaseQuery(sql, queryParams, pageable);
        //hibernate 5.2 后已作废
        //query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);;
        //改为
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List resultList = query.getResultList();
        return resultList;
    }

    /**
     * @Author yls
     * @Description 组装基本的sql查询语句
     * @Date 2020/3/24 12:51
     * @param sql 初始sql
     * @param queryParams 查询的参数
     * @param pageable 分页工具
     * @return javax.persistence.Query
     **/
    private Query getBaseQuery(String sql, QueryParams queryParams, Pageable pageable) {
        StringBuilder newSql = new StringBuilder(sql);
        Query query = null;
        if(queryParams!=null){
            List<Object> values = analysisQueryParams(newSql, queryParams);
            query = entityManager.createNativeQuery(newSql.toString());
            for(int i =0;i<values.size();i++){
                query.setParameter(i+1,values.get(i));
            }
        }else {
            query = entityManager.createNativeQuery(newSql.toString());
        }
        if (pageable!=null){
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }
        return query;
    }
}
