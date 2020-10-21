package com.authority.manager.web.dao;

import com.authority.manager.web.model.relation.SysUserRoleDO;
import com.authority.manager.base.repository.BaseJpaDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:57
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysUserRoleJpaDAO extends BaseJpaDAO<SysUserRoleDO,Integer> {
    //根据userid查询
    List<SysUserRoleDO> findByUserId(Integer userId);
}
