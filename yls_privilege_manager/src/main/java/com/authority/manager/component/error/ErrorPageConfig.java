package com.authority.manager.component.error;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author yls
 * @Date 2020/3/30 14:28
 * @Description
 * @Version 1.0
 **/
@Configuration
public class ErrorPageConfig implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView();
        switch (status) {
            case NOT_FOUND:
                mv.setViewName("redirect:/404/404.html");
                break;
            case INTERNAL_SERVER_ERROR:
                mv.setViewName("redirect:/500/500.html");
                break;
            default:
                mv.setViewName("redirect:/404/404.html");
        }
        return mv;
    }
}
