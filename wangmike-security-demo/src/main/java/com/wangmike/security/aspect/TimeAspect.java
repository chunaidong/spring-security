package com.wangmike.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 11:57
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Aspect
@Component
public class TimeAspect {


    @Around("execution(* com.wangmike.security.controller.UserController.*(..))")
    public Object aspectMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();

        Arrays.stream(args).forEach(arg->{
            System.out.println("arg is " +arg);
        });

        Object object = pjp.proceed();

        return object;
    }


}
