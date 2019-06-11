package com.itheima.spring.aop;

public class MyAdvice {

    public void before(){
        System.out.println("前置增强");
    }

    public void afterreturning(){
        System.out.println("后置增强");
    }

    public void round(){
        System.out.println("环绕增强");
    }

    public void exception(){
        System.out.println("异常通知");
    }

    public void after(){
        System.out.println("最终增强");
    }

}
