package org.aop.test002springmvc.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017/5/4.
 */
@Component
@Aspect
public class AspectTest implements ThrowsAdvice {
    private static final Log LOG = LogFactory.getLog(AspectTest.class);

    public AspectTest() {
        LOG.info("初始化切面...");
    }

    //前置通知
    @Before(value = "execution(* org.aop.test002springmvc.service.UserService.add*(..))")
    public void doBefore(JoinPoint joinPoint) {
        //JoinPoint取值示例
        Object[] objects = joinPoint.getArgs();
        for (int i = 0; i < objects.length; i++) {
            LOG.info("参数" + i + ":" + objects[i]);
        }
        LOG.info("执行了前置通知");
    }

    //后置通知
    @After(value = "execution(* org.aop.test002springmvc.service.UserService.add*(..))")
    public void doAfter() {
        LOG.info("执行了后置通知");
    }

    //环绕通知
//    @Around(value = "execution(* org.aop.test002springmvc.service.UserService.add*(..))")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        Object retVal = pjp.proceed();
//        LOG.info("执行了环绕通知");
//        return retVal;
//    }

    //获取返回后通知
    @AfterReturning(value = "execution(* org.aop.test002springmvc.service.UserService.add*(..))", returning = "retVal")
    public void doAfterReturning(JoinPoint jp, String retVal) {
        LOG.info("后置返回值通知，获得参数：" + retVal);
    }

    //异常通知
    @AfterThrowing(value = "execution(* org.aop.test002springmvc.service.UserService.add*(..))", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        LOG.info("抛出异常通知" + ex);
    }
}
