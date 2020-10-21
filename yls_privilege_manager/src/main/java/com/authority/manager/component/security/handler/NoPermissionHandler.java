package com.authority.manager.component.security.handler;

import com.authority.manager.base.http.HttpResponseVO;
import com.authority.manager.base.http.HttpStatus;
import com.authority.manager.base.utils.JsonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yls
 * @Date: 2020/10/14 10:23
 * @Description: 无权限处理器
 * @Version 1.0
 */
public class NoPermissionHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setHeader("Content-type", "application/json; charset=UTF-8");
        response.setStatus(HttpStatus.SC_OK);
        PrintWriter writer = response.getWriter();
        HttpResponseVO httpResponseVO = new HttpResponseVO();
        httpResponseVO.setMsg("无权限操作！");
        httpResponseVO.setCode(HttpStatus.SC_FORBIDDEN);
        writer.write(JsonUtils.objectToJson(httpResponseVO));
        writer.flush();
        writer.close();
    }
}
