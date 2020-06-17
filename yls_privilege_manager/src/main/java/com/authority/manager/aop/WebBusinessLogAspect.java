package com.authority.manager.aop;

import com.authority.manager.security.utils.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author yls
 * @Date 2020/3/30 17:03
 * @Description 切面编程，Aspect注解表示这是一个切面类
 * @Version 1.0
 *
 * JoinPoint包含了几个很有用的参数：
 *     Object[] getArgs：返回目标方法的参数
 *     Signature getSignature：返回目标方法的签名
 *     Object getTarget：返回被织入增强处理的目标对象
 *     Object getThis：返回AOP框架为目标对象生成的代理对象
 **/
@Aspect
@Component
public class WebBusinessLogAspect {
    //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(WebBusinessLogAspect.class);

    /**
     * @Author yls
     * @Description 切入点
     * @Date 2020/3/30 17:15
     * @param
     * @return void
     **/
    @Pointcut("execution(public * com.authority.manager.web.service.*.*(..))")
    public void serviceAspect(){

    }

    /**
     * @Author yls
     * @Description 前置通知
     * @Date 2020/3/30 17:15
     * @param joinPoint
     * @return void
     **/
    @Before(value = "serviceAspect()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        LOGGER.info(name+"方法开始执行....");
    }

    /**
     * @Author yls
     * @Description 后置通知
     * @Date 2020/3/30 17:15
     * @param joinPoint
     * @return void
     **/
    @After(value = "serviceAspect()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.toString());
        LOGGER.info(name+"方法执行结束...."+ Arrays.toString(args));
    }

    /**
     * @Author yls
     * @Description 返回通知
     * @Date 2020/3/30 17:16
     * @param joinPoint
     * @param result 返回的结果
     * @return void
     **/
    @AfterReturning(value = "serviceAspect()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        LOGGER.info(name+"方法返回值...."+result);
    }

    /**
     * @Author yls
     * @Description 异常通知
     * @Date 2020/3/30 17:17
     * @param joinPoint
     * @param e 异常
     * @return void
     **/
    @AfterThrowing(value = "serviceAspect()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String name = joinPoint.getSignature().getName();
        LOGGER.info(name+"方法抛出异常，异常是："+e);
    }

    /**
     * @Author yls
     * @Description 环绕通知
     * @Date 2020/3/30 17:17
     * @param pjq
     * @return java.lang.Object
     **/
    @Around("serviceAspect()")
    public Object around(ProceedingJoinPoint pjq)throws Throwable{
        return pjq.proceed();
    }
}
