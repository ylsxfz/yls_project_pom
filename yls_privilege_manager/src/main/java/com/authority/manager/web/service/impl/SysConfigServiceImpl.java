package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysConfigDao;
import com.authority.manager.web.service.SysConfigService;
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
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public BaseDao getDao() {
        return sysConfigDao;
    }
}
