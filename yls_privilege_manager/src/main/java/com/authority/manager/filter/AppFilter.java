package com.authority.manager.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author yls
 * @Date 2020/3/30 11:09
 * @Description
 * @Version 1.0
 **/
@WebFilter(filterName = "appFilter",urlPatterns = "/web/*")
public class AppFilter implements Filter {
    //日志
    private static final Logger LOGGER  = LoggerFactory.getLogger(AppFilter.class);
    /**
     * @Description 初始化方法
     * @Date 2020/3/30 11:10
     * @param filterConfig
     * @return void
     **/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * @Description 主方法
     * @Date 2020/3/30 11:11
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @return void
     **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }


    /**
     * @Description 当Web应用移除或者服务器停止时调用
     * @Date 2020/3/30 11:12
     * @param
     * @return void
     **/
    @Override
    public void destroy() {
    }


}
