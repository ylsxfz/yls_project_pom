package com.authority.manager.component.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author yls
 * @Date 2020/3/30 11:21
 * @Description 容器启动关闭监听器
 * @Version 1.0
 **/
@WebListener
public class AppContextListener implements ServletContextListener {
    //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(AppContextListener.class);
    /**
     * @Author yls
     * @Description 当servlet容器启动Web应用时调用该方法
     * @Date 2020/3/30 11:22
     * @param servletContextEvent
     * @return void
     **/
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }

    /**
     * @Author yls
     * @Description 当servlet容器终止web应用时调用该方法
     * @Date 2020/3/30 11:23
     * @param servletContextEvent
     * @return void
     **/
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
