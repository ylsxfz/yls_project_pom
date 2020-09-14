package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysRoleDO;
import com.yls.core.repository.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysRoleDAO extends BaseDAO<SysRoleDO,Integer> {
    SysRoleDO findByName(String name);
}
