package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysRole;
import com.yls.core.repository.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysRoleDao extends BaseDao<SysRole,Integer> {
    SysRole findByName(String name);
}
