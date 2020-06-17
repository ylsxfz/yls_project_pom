package com.authority.manager.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author yls
 * @Date 2020/4/12 12:37
 * @Description request请求监听器
 * @Version 1.0
 **/
@WebListener("/*")
public class AppRequestListener implements ServletRequestListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }
}
