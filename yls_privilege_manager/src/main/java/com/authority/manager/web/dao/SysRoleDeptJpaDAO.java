package com.authority.manager.web.dao;

import com.authority.manager.web.model.relation.SysRoleDeptDO;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:53
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysRoleDeptJpaDAO extends BaseJpaDAO<SysRoleDeptDO,Integer> {
}
