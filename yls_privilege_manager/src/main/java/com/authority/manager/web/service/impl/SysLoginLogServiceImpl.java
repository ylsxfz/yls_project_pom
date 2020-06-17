package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysLoginLogDao;
import com.authority.manager.web.service.SysLoginLogService;
import com.yls.core.repository.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogDao sysLoginLogDao;

    @Override
    public BaseDao getDao() {
        return sysLoginLogDao;
    }
}
