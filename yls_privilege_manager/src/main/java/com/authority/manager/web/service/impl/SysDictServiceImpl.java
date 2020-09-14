package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysDictDAO;
import com.authority.manager.web.service.SysDictService;
import com.yls.core.repository.BaseDAO;
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
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictDAO sysDictDao;


    @Override
    public BaseDAO getDao() {
        return sysDictDao;
    }
}
