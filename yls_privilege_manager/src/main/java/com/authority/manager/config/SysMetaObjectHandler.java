package com.authority.manager.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @Auther: yls
 * @Date: 2020/8/25 16:08
 * @Description: mybatis-plus的填充字段
 * @Version 1.0
 */
@Component
public class SysMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
