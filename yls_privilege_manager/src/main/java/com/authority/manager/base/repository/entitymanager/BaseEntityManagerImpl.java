package com.authority.manager.base.repository.entitymanager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yls
 * @Date 2020/3/22 10:56
 * @Description 通用jpa接口基础实现类
 * @Version 1.0
 **/
@Repository
public class BaseEntityManagerImpl<T,ID> implements BaseEntityManager<T,ID> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean saveEntity(T entity) {
        boolean flag = false;
        try{
            entityManager.persist(entity);
            flag = true;
        }catch (Exception e){
            System.out.println("---------保存出错-----------");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public T findByID(Class<T> clazz, ID id) {
        T t = null;
        try{
            t = entityManager.find(clazz,id);
        }catch (Exception e){
            System.out.println("---------根据id出错-----------");
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public List<T> findByField(Class<T> clazz, String field, Object value) {
        String tablename = clazz.getName();
        List<T> list = new ArrayList<>();
        try{
            //组装sql
            String sql = "from "+tablename+" u where u."+field+"=?1";
            Query query = entityManager.createQuery(sql);
            //拼接参数
            query.setParameter(1,value);
            list = query.getResultList();
            entityManager.close();
        }catch (Exception e){
            System.out.println("---------根据字段"+field+"查询出错-----------");
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public Boolean deleteEntity(T entity) {
        boolean flag = false;
        try{
            entityManager.remove(entityManager.merge(entity));
            flag = true;
        }catch (Exception e){
            System.out.println("-----------删除出错-----------");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Boolean update(T entity) {
        return null;
    }


    @Override
    public Boolean deleteById(Class<T> clazz, ID id) {
        boolean flag = false;
        try{
            String tableName = clazz.getName();
            String sql = "delete from "+tableName+" u where u.id=?1";
            Query query = entityManager.createQuery(sql);
            query.setParameter(1,id);
            int i = query.executeUpdate();
            if (i != 0){
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Boolean deleteByIds(Class<T> clazz, List<ID> ids) {
        boolean flag = false;
        int index = 1;
        try{
            String tableName = clazz.getName();
            String sql ="delet from "+tableName+" u where u.id in (?1)";
            Query query = entityManager.createQuery(sql);
            String idStr = StringUtils.join(ids, ',');
            query.setParameter(1,idStr);
            int i = query.executeUpdate();
            if (i != 0 ){
                flag = true;
            }
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
