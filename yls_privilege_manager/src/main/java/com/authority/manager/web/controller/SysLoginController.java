package com.authority.manager.web.controller;

import com.authority.manager.component.security.JwtAuthenticatioToken;
import com.authority.manager.component.security.utils.PasswordUtils;
import com.authority.manager.component.security.utils.SecurityUtils;
import com.authority.manager.contant.SysContants;
import com.authority.manager.vo.LoginBean;
import com.authority.manager.web.model.SysUser;
import com.authority.manager.web.model.log.SysLoginLog;
import com.authority.manager.web.service.SysLoginLogService;
import com.authority.manager.web.service.SysUserService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.yls.common.utils.IOUtils;
import com.yls.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 登录控制器
 * @Version 1.0
 **/
@RestController
@Api(tags = "登录接口")
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private Producer producer;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysLoginLogService sysLoginLogService;



    /**
     * @Author yls
     * @Description  生成验证码
     * @Date 2020/4/6 10:22
     * @param response 返回请求体
     * @param request 请求
     * @return void
     **/
    @ApiOperation(value = "生成验证码")
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws Exception{
        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存img到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpg",out);
        IOUtils.closeQuietly(out);
    }

    /**
     * @Author yls
     * @Description 登录接口
     * @Date 2020/4/6 10:22
     * @param loginBean 登录实例
     * @param request 请求
     * @return com.authority.manager.base.http.HttpResult
     **/
    @ApiOperation(value = "登录接口")
    @PostMapping(value = "/login")
    public HttpResult login(@ApiParam(value = "登录对象", required = true)@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        System.err.println("后台生成的验证码："+captcha);
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.err.println("前台验证码："+kaptcha);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        SysLoginLog sysLoginLog = new SysLoginLog(SysContants.LOGIN);
        sysLoginLogService.save(sysLoginLog);
        return HttpResult.ok(token);
    }
}
