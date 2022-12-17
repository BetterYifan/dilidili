package com.dilidili.log.aspect;

import com.dilidili.log.InterfaceLogUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * author: yiFan
 */
@Aspect
@Slf4j
@Component
public class InterfaceLogAspect {
    private final String POINT = "@annotation (com.dilidili.annotation.InterfaceLogging)";

    @Pointcut(POINT)
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 入参
        Object[] params = point.getArgs();
        long begin = System.currentTimeMillis();
        Object result = null;
        long spend = 0L;
        try {
            result = point.proceed();
            spend = System.currentTimeMillis() - begin;
        } catch (Exception e) {
            InterfaceLogUtil.cliFail("cost: " + String.valueOf(spend));
            return result;
        }
        InterfaceLogUtil.cliSuccess("cost: " + String.valueOf(spend));
        return result;
    }

}
