package com.authority.manager.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Auther: yls
 * @Date: 2020/08/23 21:32
 * @Description:
 * @Version 1.0
 */
@Configuration
@MapperScan("com.authority.manager.functions.dao")
public class MybatisConfig {
    private final static Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Bean
    public GlobalConfig globalConfig(){
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MybatisMetaObjectHandler());
        return globalConfig;
    }


    /**
     * 功能描述:
     * 〈配置分页插件〉
     *
     * @author : yls
     * @date : 2020/10/16 13:50
     * @return : com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        logger.debug("注册分页插件");
        return new PaginationInterceptor();
    }

    /**
     * 功能描述:
     * 〈SQL执行效率插件〉
     *
     * @author : yls
     * @date : 2020/10/16 13:50
     * @param
     * @return : com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     */
    @Bean
    @Profile({"test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 功能描述:
     * 〈逻辑删除用，3.1.1之后的版本可不需要配置该bean，但项目这里用的是3.1.0的〉
     *
     * @author : yls
     * @date : 2020/10/16 13:51
     * @param
     * @return : com.baomidou.mybatisplus.core.injector.ISqlInjector
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }


}
