package com.authority.manager.web.dao;

import com.authority.manager.web.model.log.SysLog;
import com.yls.core.repository.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:50
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysLogDao extends BaseDao<SysLog,Integer> {
}
