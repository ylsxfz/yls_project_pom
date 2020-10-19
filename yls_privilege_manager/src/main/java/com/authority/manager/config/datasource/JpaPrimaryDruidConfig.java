package com.authority.manager.config.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/10/19 20:19
 * @Description: 项目的主数据源jpa配置
 *              1、注意：注解处basePackages=“****”//此处对应程序dao层 全路径包名
 *              2、LocalContainerEntityManagerFactoryBean方法下的.packeages(“***”)//pojo类全类名
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "primaryPlatformTransactionManager",
        entityManagerFactoryRef = "primaryEntityManagerFactoryBean",
        basePackages = {"com.authority.manager.web.dao","com.authority.manager.functions.dao"}
)
public class JpaPrimaryDruidConfig {
    @Resource
    @Qualifier("primaryDruidDataSource")
    DataSource dataSource;

    @Autowired
    JpaProperties jpaProperties;

    @Bean(name = "primaryEntityManagerFactoryBean")
    @Primary
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource)
                .properties(getVendorProperties())
                .packages("com.authority.manager.web.model","com.authority.manager.functions.model")
                .persistenceUnit("primaryEntityManagerFactoryBean")
                .build();
    }

    @Bean(name = "primaryPlatformTransactionManager")
    @Primary
    PlatformTransactionManager platformTransactionManager(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean factoryBean = entityManagerFactoryBean(builder);
        return new JpaTransactionManager(factoryBean.getObject());
    }

    private Map getVendorProperties() {
        HibernateSettings hibernateSettings = new HibernateSettings();
        // hibernateSettings.ddlAuto(ddlAuto);
        return jpaProperties.getHibernateProperties(hibernateSettings);
    }
}
