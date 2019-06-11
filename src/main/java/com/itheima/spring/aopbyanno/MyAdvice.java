package com.itheima.spring.aopbyanno;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.itheima.spring.aopbyanno.*.*(..))")
    public void pointcut1(){

    }

    @Before("pointcut1()")
    public void before(){
        System.out.println("前置增强--注解");
    }

    public void afterreturning(){
        System.out.println("后置增强");
    }

    public void round(){
        System.out.println("环绕增强");
    }
    @AfterThrowing("pointcut1()")
    public void exception(){
        System.out.println("异常通知");
    }

    public void after(){
        System.out.println("最终增强");
    }

}
