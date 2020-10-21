package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysLogJpaDAO;
import com.authority.manager.web.service.SysLogJpaService;
import com.authority.manager.base.repository.BaseJpaDAO;
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
public class SysLogJpaServiceImpl implements SysLogJpaService {
    @Autowired
    private SysLogJpaDAO sysLogDao;

    @Override
    public BaseJpaDAO getDao() {
        return sysLogDao;
    }
}
