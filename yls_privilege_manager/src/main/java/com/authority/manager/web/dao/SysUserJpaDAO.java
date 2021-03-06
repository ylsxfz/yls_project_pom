package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysUserDO;
import com.authority.manager.base.repository.BaseJpaDAO;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:54
 * @Description
 * @Version 1.0
 **/
@Repository
@RepositoryRestResource(exported = false)
public interface SysUserJpaDAO extends BaseJpaDAO<SysUserDO,Integer> {
    //根据姓名查询
    SysUserDO findByName(String name);

    @RestResource(exported = false)
    @Override
    void deleteById(Integer integer);
}
