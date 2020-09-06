package com.authority.manager.mybatis;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther: yls
 * @Date: 2020/08/23 21:32
 * @Description:
 * @Version 1.0
 */
@Configuration
@MapperScan("com.authority.manager.functions.dao")
public class MybatisConfig {

//    @Autowired
//    private DataSource dataSource;

//    @Bean
//    public SqlSessionFactory sqlSessionFactory()throws Exception{
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        return sessionFactory.getObject();
//    }
}
