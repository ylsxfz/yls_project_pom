package com.authority.manager.component.jsonfilter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: yls
 * @Date: 2020/10/21 23:38
 * @Description:
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFieldFilter {
    Class<?> type();// 对哪个类的属性进行过滤

    String include() default "";// 包含哪些字段，即哪些字段可以显示

    String exclude() default "";// 不包含哪些字段，即哪些字段不可以显示
}