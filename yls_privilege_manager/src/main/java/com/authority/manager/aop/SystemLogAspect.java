package com.authority.manager.aop;

import com.alibaba.fastjson.JSON;
import com.authority.manager.component.security.utils.SecurityUtils;
import com.authority.manager.log.annotation.SystemControllerLog;
import com.authority.manager.log.model.SystemLogDO;
import com.authority.manager.log.service.SystemLogService;
import com.authority.manager.log.utils.HttpContextUtils;
import com.authority.manager.log.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Auther: yls
 * @Date: 2020/10/19 23:50
 * @Description: 系统日志记录
 * @Version 1.0
 */
@Aspect
@Component
public class SystemLogAspect {
    @Autowired
    private SystemLogService systemLogService;

    /**
     * 功能描述:
     * 〈定义切点 @Pointcut：在注解的位置切入代码〉
     * @author : yls
     * @date : 2020/10/19 23:56
     * @return : void
     */
    @Pointcut("@annotation( com.authority.manager.log.annotation.SystemControllerLog )")
    public void systemLogPointcut() {

    }

    /**
     * 功能描述:
     * 〈环绕通知：可以监控方法从开始到结束的执行情况〉
     *
     * @author : yls
     * @date : 2020/10/20 10:16
     * @param joinPoint 切入流程
     * @return : void
     */
    @Around("systemLogPointcut()")
    public void saveSysLog(ProceedingJoinPoint joinPoint) {
        // 日志
        SystemLogDO systemLogDO = new SystemLogDO();

        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();

        // 获取操作
        SystemControllerLog systemControllerLog = method.getAnnotation(SystemControllerLog.class);
        if (systemControllerLog != null) {
            String value = systemControllerLog.operation();
            systemLogDO.setOperation(value);//保存获取的操作
        }

        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();
        systemLogDO.setMethod(className + "." + methodName);

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        // 将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        systemLogDO.setParams(params);

        // 获取用户名
        String username = SecurityUtils.getUsername();
        systemLogDO.setUserName(username);

        /**
         * 获取请求体内容
         */
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 获取请求地址
        String requestUri = request.getRequestURI();
        systemLogDO.setRequestUri(requestUri);
        // 获取请求方式
        String requestMethod = request.getMethod();
        systemLogDO.setRequestMethod(requestMethod);
        // 获取请求IP
        String remoteAddr1 = request.getRemoteAddr();
        String ipAddr = IPUtils.getIpAddr(request);
        systemLogDO.setIp(ipAddr);

        Object proceed = null;
        try {
            // 执行增强后的方法
            //proceed = joinPoint.proceed();
            if (method.isAnnotationPresent(SystemControllerLog.class)) {
                systemLogDO.setExceptionLog("无异常");
                systemLogDO.setType("info");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            systemLogDO.setExceptionLog(throwable.getMessage());
            systemLogDO.setType("Err");
        } finally {
            //调用service保存SysLog实体类到数据库
            systemLogService.save(systemLogDO);
        }

    }
}
