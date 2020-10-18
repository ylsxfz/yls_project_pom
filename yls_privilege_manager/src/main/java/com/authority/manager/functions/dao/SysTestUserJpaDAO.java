package com.authority.manager.functions.dao;

import com.authority.manager.functions.model.SysTestJpaUser;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.stereotype.Repository;

/**
 * @Auther: yls
 * @Date: 2020/10/17 15:45
 * @Description:
 * @Version 1.0
 */
@Repository
public interface SysTestUserJpaDAO extends BaseJpaDAO<SysTestJpaUser, Integer> {
}
