package com.itheima.spring.aopbyanno;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class MyTarget {

    public void save(){
        System.out.println("save.......");

    }

    public void del(){
        System.out.println("del........");
        int i = 1/0;
    }

}
