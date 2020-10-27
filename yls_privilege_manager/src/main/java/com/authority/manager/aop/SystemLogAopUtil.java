package com.authority.manager.aop;

import com.authority.manager.base.utils.JsonUtils;
import com.authority.manager.component.security.utils.SecurityUtils;
import com.authority.manager.log.annotation.SystemControllerLog;
import com.authority.manager.log.model.SystemLogDO;
import com.authority.manager.log.service.SystemLogService;
import com.authority.manager.log.utils.HttpContextUtils;
import com.authority.manager.log.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/10/27 20:47
 * @Description:
 * @Version 1.0
 */
@Component
public class SystemLogAopUtil {

    @Autowired
    private SystemLogService systemLogService;

    public Object getSystemLog(ProceedingJoinPoint joinPoint) throws Exception {
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
        LocalVariableTableParameterNameDiscoverer paramNames = new LocalVariableTableParameterNameDiscoverer();
        String[] params = paramNames.getParameterNames(method);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (!(args[i] instanceof HttpServletRequest) && !(args[i] instanceof HttpServletResponse) && !(args[i] instanceof MultipartFile)) {
                assert params != null;
                if (args[i] instanceof Serializable){
                    map.put(params[i], JsonUtils.objectToJson(args[i]));
                }else {
                    map.put(params[i], args[i].toString());
                }
            }
        }
        systemLogDO.setParams(JsonUtils.objectToJson(map));
        systemLogDO.setParams(args.toString());
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
            proceed = joinPoint.proceed();
            if (method.isAnnotationPresent(SystemControllerLog.class)) {
                systemLogDO.setExceptionLog("无异常");
                systemLogDO.setType("info");
            }
            systemLogDO.setExceptionLog("无异常");
            systemLogDO.setType("info");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            systemLogDO.setExceptionLog(throwable.getMessage());
            systemLogDO.setType("Err");

            /**
             * 过滤无权限操作
             */
            if (throwable instanceof AccessDeniedException) {
                throw new AccessDeniedException(throwable.getMessage());
            } else {
                throw new Exception(throwable.getMessage());
            }

        } finally {
            this.saveLog(systemLogDO);
        }
        return proceed;
    }

    @Async
    public void saveLog(SystemLogDO systemLogDO){
        //调用service保存SysLog实体类到数据库
        systemLogService.save(systemLogDO);
    }
}
