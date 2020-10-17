package com.authority.manager.config;

import com.authority.manager.component.security.utils.SecurityUtils;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: yls
 * @Date: 2020/8/25 16:08
 * @Description: mybatis-plus的填充字段
 * @Version 1.0
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 功能描述:
     * 〈insert（添加数据）：需要自动填充的字段〉
     *
     * @author : yls
     * @date : 2020/10/16 13:58
     * @param metaObject
     * @return : void
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        String username = SecurityUtils.getUsername();
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy", username, metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", username, metaObject);
        // 删除值
        this.setFieldValByName("deleted", 0, metaObject);
    }

    /**
     * 功能描述:
     * 〈update（更新数据）：需要自动填充的字段〉
     *
     * @author : yls
     * @date : 2020/10/16 13:58
     * @param metaObject
     * @return : void
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        String username = SecurityUtils.getUsername();
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", username, metaObject);
    }
}
