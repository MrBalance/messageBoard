package com.javen.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: yunzhang.du
 * @description:
 * @Date: 2019-06-25 20:13
 */
@Component
@Aspect
@Slf4j
public class LogAdvice {
    // 配置切点 及要传的参数
    @Pointcut("execution(* com.javen.service..*(..))")
    public void pointCut() {
    }
    /*// 方法开始执行时通知
    @Before("pointCut()")
    public void beforeLog(JoinPoint joinPoint) {
        String name = joinPoint.getTarget().getClass().getName();
        log.info("| 开始执行前置通知 日志记录|==> " + name);
    }
    // 方法执行完后通知
    @After("pointCut()")
    public void afterLog(JoinPoint joinPoint) {
        String name = joinPoint.getTarget().getClass().getName();
        log.info("|开始执行后置通知 日志记录|==> " + name);
    }
    // 执行成功后通知
    @AfterReturning("pointCut()")
    public void afterReturningLog(JoinPoint joinPoint) {
        String name = joinPoint.getTarget().getClass().getName();
        log.info("|方法成功执行后通知 日志记录|==> " + name);
    }
    // 抛出异常后通知
    @AfterThrowing("pointCut()")
    public void afterThrowingLog(JoinPoint joinPoint) {
        String name = joinPoint.getTarget().getClass().getName();
        log.info("|方法抛出异常后执行通知 日志记录|==> " + name);
    }*/
    // 环绕通知
    @Around("pointCut()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) {
        // 1.获取节点信息
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        // 2.before日志
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("-|开始执行|-|类|-[").append(className).append("]");
        logInfo.append("-|调用方法|-[").append(methodName).append("]");
        logInfo.append("-|参数|-[");
        for (Object arg : args) {
            logInfo.append(arg.toString());
        }
        logInfo.append("]");
        try {
            log.info(logInfo.toString());
            logInfo.setLength(0);
            // 3.执行时间统计
            long start = System.currentTimeMillis();
            // 有返回参数 则需返回值
            result =  joinPoint.proceed();
            long end = System.currentTimeMillis();
            logInfo.append("-|总共执行时长").append((end - start)).append(" 毫秒|");
            log.info(logInfo.toString());
            logInfo.setLength(0);
            // 4.执行成功日志
            logInfo.append("-|执行成功|-|类|-[").append(className).append("]");
            logInfo.append("-|调用方法|-[").append(methodName).append("]");
            logInfo.append("-|返回值|-[").append(result.toString()).append("]");
            log.info(logInfo.toString());
        } catch (Throwable t) {
            // 5.异常日志
            log.error("-|出现异常|-|类|-["+className+"]-|方法|-["+methodName+"]-|异常信息|-[" + t.toString()+"]");
        } finally {
            log.info("-|处理结束|-|类|-["+className+"]-|方法|-["+methodName+"]");
        }
        return result;
    }
}
