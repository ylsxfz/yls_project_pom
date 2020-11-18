package com.authority.manager.component.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * @Auther: yls
 * @Date: 2020/10/19 23:59
 * @Description: 自定义 service 层的组合注解
 * @Version 1.0
 */
@Target(ElementType.TYPE) // 注解放置的目标位置，METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented // 生成文档
@Transactional
@Service
public @interface TransactionalService {

}
