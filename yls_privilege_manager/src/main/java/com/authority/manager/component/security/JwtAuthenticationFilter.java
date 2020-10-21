package com.authority.manager.component.security;

import com.authority.manager.component.security.utils.SecurityUtils;
import com.authority.manager.component.http.HttpResponseVO;
import com.authority.manager.base.http.HttpStatus;
import com.authority.manager.base.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author yls
 * @Description 登录认证过滤器
 * @Date 2020/4/6 9:33
 **/
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {


    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取token, 并检查登录状态
        SecurityUtils.checkAuthentication(request);
        chain.doFilter(request, response);
//        try {
//            if (!SecurityUtils.checkAuthentication(request)) {
//                loginOverdue(response);
//            } else {
//                chain.doFilter(request, response);
//            }
//        } catch (ExpiredJwtException e) {
//            loginOverdue(response);
//            e.printStackTrace();
//        }
    }

    /**
     * 功能描述:
     * 〈登录失效触发该方法〉
     *
     * @author : yls
     * @date : 2020/10/20 10:03
     * @param response 登录失效的时候的响应消息
     * @return : void
     */
    private void loginOverdue(HttpServletResponse response) {
        response.setHeader("Content-type", "application/json; charset=UTF-8");
        try (PrintWriter printWriter = response.getWriter()) {
            SecurityUtils.removeContext();
            response.setCharacterEncoding("UTF-8");
            HttpResponseVO httpResponseVO = new HttpResponseVO();
            httpResponseVO.setCode(HttpStatus.SC_FORBIDDEN);
            httpResponseVO.setMsg("登录失效!");
            printWriter.write(JsonUtils.objectToJson(httpResponseVO));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}