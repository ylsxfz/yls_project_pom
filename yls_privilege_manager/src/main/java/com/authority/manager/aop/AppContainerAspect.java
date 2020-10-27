package com.authority.manager.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author yls
 * @Date 2020/4/14 10:41
 * @Description 切面类，监控当前切面的类的方法执行情况
 * @Version 1.0
 **/
@Aspect
@Component
public class AppContainerAspect {
    //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(AppContainerAspect.class);

    /**
     * 功能描述:
     * 〈设置切面的切入点，主要是设置哪些类和方法需要使用切面编程〉
     * @author : yls
     * @date : 2020/07/12 10:29
     * @param
     * @return : void
     */
    @Pointcut("execution(* com.authority.manager.component.filter.*.*(..)) " +
            "|| execution(* com.authority.manager.component.init.*.*(..)) " +
            "|| execution(* com.authority.manager.component.interceptor.*.*(..))" +
            "|| execution(* com.authority.manager.component.listener.*.*(..))" +
            "|| execution(* com.authority.manager.component.quartz.*.*(..))")
    public void appContainerAspect(){

    }

    /**
     * 功能描述:
     * 〈前置通知：在方法执行之前执行该通知，通知用户该方法开始执行〉
     * @author : yls
     * @date : 2020/07/12 10:30
     * @param joinPoint 切入点
     * @return : void
     */
    @Before(value = "appContainerAspect()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
//        LOGGER.info(name+"方法开始执行....");
    }

    /**
     * 功能描述:
     * 〈后置通知：在方法执行之后执行该通知，通知用户该方法已经执行完成〉
     * @author : yls
     * @date : 2020/07/12 10:31
     * @param joinPoint 切入点
     * @return : void
     */
    @After(value = "appContainerAspect()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.toString());
//        LOGGER.info(name+"方法执行结束...."+ Arrays.toString(args));
    }

    /**
     * @Author yls
     * @Date 2020/3/30 17:16
     * @param joinPoint 切入点
     * @param result 返回的结果
     * @return void
     **/
    @AfterReturning(value = "appContainerAspect()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
//        LOGGER.info(name+"方法返回值...."+result);
    }

    /**
     * 功能描述:
     * 〈异常通知：在方法执行出现异常时执行该通知，通知用户该方法出现了某种异常〉
     * @Author yls
     * @Date 2020/3/30 17:17
     * @param joinPoint
     * @param e 异常
     * @return void
     **/
    @AfterThrowing(value = "appContainerAspect()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        String name = joinPoint.getSignature().getName();
        LOGGER.info(name+"方法抛出异常，异常是："+e);
    }

    /**
     * 功能描述:
     * 〈环绕通知：可以监控方法从开始到结束的执行情况〉
     * @Author yls
     * @Date 2020/3/30 17:17
     * @param pjq
     * @return java.lang.Object
     **/
    @Around("appContainerAspect()")
    public Object around(ProceedingJoinPoint pjq)throws Throwable{
        return pjq.proceed();
    }
}
