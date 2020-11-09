package com.authority.manager.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private SystemLogAopUtil systemLogAopUtil;

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
    public Object saveSysLog(ProceedingJoinPoint joinPoint) throws Throwable {
        return systemLogAopUtil.getSystemLog(joinPoint);
    }


}
