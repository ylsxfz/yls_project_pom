package com.authority.manager.component.security.handler;

import com.authority.manager.component.http.HttpResponseVO;
import com.yls.core.http.HttpStatus;
import com.yls.core.utils.JsonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yls
 * @Date: 2020/10/14 10:18
 * @Description: 登出注销用户处理器
 * @Version 1.0
 */
public class SysLogoutSuccessHandler extends HttpStatusReturningLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setHeader("Content-type", "application/json; charset=UTF-8");
        response.setStatus(HttpStatus.SC_OK);
        PrintWriter writer = response.getWriter();
        writer.write(JsonUtils.objectToJson(HttpResponseVO.ok("注销用户成功")));
        writer.flush();
        writer.close();
    }
}
