package com.authority.manager.log.annotation;

import java.lang.annotation.*;

/**
 * @Auther: yls
 * @Date: 2020/10/19 23:59
 * @Description: 利用 AOP 记录日志的自定义注解
 * @Version 1.0
 */
@Target(ElementType.METHOD) // 注解放置的目标位置，METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented // 生成文档
public @interface SystemControllerLog {
    /**
     * 操作事件
     */
    String operation() default "";

    /**
     * 日志类型
     */
    String type() default "info";
}
