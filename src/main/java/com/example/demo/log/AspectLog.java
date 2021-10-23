package com.example.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.ejb.AfterBegin;
import javax.interceptor.AroundInvoke;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
class AspectLog {
    @Pointcut("execution(public * com.example.demo.domain.Role.*(..))")
    public void callAtMyServicePublic() { }

    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + ", args=[" + args + "]");
    }
    @Around("callAtMyServicePublic()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime=System.currentTimeMillis();

        Object returnValue=joinPoint.proceed();
        StringBuilder message =new StringBuilder("MethodL: ");
        message.append(joinPoint.getSignature().getName()).append("!");

        long spendTime=System.currentTimeMillis()-startTime;
        message.append("time:"+spendTime+"milliseconds");
        log.info(message.toString());
        return returnValue;

    }
    @AfterThrowing(pointcut = "execution(public * com.example.demo.domain.Role.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable
    {
        System.out.println("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
    }
    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        log.info("after " + jp.toString());
    }


}

