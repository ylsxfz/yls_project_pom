package com.authority.manager.log.service.impl;

import com.authority.manager.log.dao.SystemLogJpaDAO;
import com.authority.manager.log.service.SystemLogService;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yls
 * @Date: 2020/10/19 23:54
 * @Description:
 * @Version 1.0
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogJpaDAO systemLogJpaDAO;

    @Override
    public BaseJpaDAO getDao() {
        return systemLogJpaDAO;
    }

}
