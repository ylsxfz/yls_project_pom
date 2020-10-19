package com.authority.manager.log.dao;

import com.authority.manager.log.model.SystemLogDO;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:50
 * @Description 日志的dao层
 * @Version 1.0
 **/
@Repository
public interface SystemLogJpaDAO extends BaseJpaDAO<SystemLogDO,Integer> {
}
