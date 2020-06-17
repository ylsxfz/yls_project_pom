package com.yls.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author yls
 * @Date 2020/4/9 16:43
 * @Description 在转发请求前进行token认证，如果请求没有token，
 *              返回"there is no request token!"提示信息。
 * @Version 1.0
 **/
@Component
public class MyZuulFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        //表示是否需要执行该filter,true表示执行，false表示不执行
        return true;
    }


    /**
     * @Author yls
     * @Description 定义filter的类型
     *              pre：可以在请求被路由之前调用
     *              route：在路由请求时候被调用
     *              post：在route和error过滤器之后被调用
     *              error：处理请求时发生错误时被调用
     * @Date 2020/4/9 17:03
     * @return java.lang.String
     **/
    @Override
    public String filterType() {
        //定义filter的类型，有pre、route、post、error四种
        return "pre";
    }

    @Override
    public int filterOrder() {
        //定义filter的顺序，数字越小，表示顺序越高、越先执行。
        return 0;
    }

    /**
     * @Author yls
     * @Description 需要执行的具体操作
     * @Date 2020/4/9 17:04
     * @param
     * @return java.lang.Object
     **/
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        System.out.println("登录令牌："+token);
        //如果没有携带token令牌信息，拦截请求，并返回提示信息。
        if(token==null || "".equals(token.trim())){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                //返回错误提示信息
                ctx.getResponse().getWriter().write("there is no requets token");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
