package com.authority.manager.config;

import com.authority.manager.component.security.JwtAuthenticationFilter;
import com.authority.manager.component.security.JwtAuthenticationProvider;
import com.authority.manager.component.security.handler.SysLogoutSuccessHandler;
import com.authority.manager.component.security.handler.NoPermissionHandler;
import com.authority.manager.component.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author yls
 * @Description Spring Security配置
 * @Date 2020/4/6 10:00
 **/
@Configuration
@EnableWebSecurity    // 开启Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true)    // 开启权限注解，如：@PreAuthorize注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 用户业务服务接口
     */
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * 功能描述:
     * 〈引入自定义身份验证组件〉
     *
     * @param auth
     * @return : void
     * @author : yls
     * @date : 2020/07/12 10:51
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
    }


    /**
     * 功能描述:
     * 〈springboot的安全管理机制，结合jwt对请求的验证〉
     *
     * @param http http安全管理机制
     * @return : void
     * @author : yls
     * @date : 2020/07/12 10:49
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // web jars
                .antMatchers("/webjars/**").permitAll()
                // 查看SQL监控（druid）
                .antMatchers("/druid/**").permitAll()
                // 首页和登录页面
                .antMatchers("/").permitAll()
                .antMatchers("/sys/login/login").permitAll()
                //错误界面
                .antMatchers("/404/**").permitAll()
                .antMatchers("/500/**").permitAll()
                .antMatchers("/test/**").permitAll()
                //webservice
                .antMatchers("/services/**").permitAll()
                // swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                // 验证码
                .antMatchers("/sys/login/captcha.jpg**").permitAll()
                // 服务监控
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().permitAll();
                // 其他所有请求需要身份认证
//                .anyRequest().authenticated();

        //权限过滤器
        http.exceptionHandling().accessDeniedHandler(new NoPermissionHandler());

        // token验证过滤器
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

        // 退出登录处理器
        http.logout().addLogoutHandler(new LogoutHandler() {
            @Override
            public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
                SecurityUtils.logout(httpServletRequest, httpServletResponse, authentication);
            }
        })
                .logoutSuccessHandler(new SysLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .deleteCookies("token")
                .clearAuthentication(true);
        //允许页面被嵌套加载
        http.headers().frameOptions().disable();

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}