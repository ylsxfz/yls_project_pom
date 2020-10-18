package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysLoginLogJpaDAO;
import com.authority.manager.web.service.SysLoginLogJpaService;
import com.yls.core.repository.BaseJpaDAO;
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
public class SysLoginLogJpaServiceImpl implements SysLoginLogJpaService {

    @Autowired
    private SysLoginLogJpaDAO sysLoginLogDao;

    @Override
    public BaseJpaDAO getDao() {
        return sysLoginLogDao;
    }
}
