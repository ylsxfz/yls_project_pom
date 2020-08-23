package com.authority.manager.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Auther: yls
 * @Date: 2020/08/23 21:32
 * @Description:
 * @Version 1.0
 */
@Configuration
@MapperScan("com.authority.manager.web_business.**.dao")
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory()throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //扫描model
        sessionFactory.setTypeAliasesPackage("com.authority.manager.web_business.**.model");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //扫描映射文件
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/sqlmap/*.xml"));
        return sessionFactory.getObject();
    }
}
