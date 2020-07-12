package com.authority.manager.component.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author yls
 * @Date 2020/4/12 12:00
 * @Description 监听创建的session
 * @Version 1.0
 **/
@WebListener
public class AppHttpSessionListener implements HttpSessionListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppHttpSessionListener.class);

    //在线人数统计
    public static Integer onLine = 0;

    /**
     * @Author yls
     * @Description 创建session
     * @Date 2020/4/14 11:29
     * @param httpSessionEvent
     * @return void
     **/
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onLine ++ ;
    }

    /**
     * @Author yls
     * @Description 销毁session
     * @Date 2020/4/14 11:29
     * @return
     **/
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onLine -- ;
    }
}
