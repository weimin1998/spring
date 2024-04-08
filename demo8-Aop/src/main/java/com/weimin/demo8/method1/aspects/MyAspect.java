package com.weimin.demo8.method1.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    @Before("execution(* com.weimin.demo8.method1.service.MyService.*())")
    public void before(){
        System.out.println("before");
    }
}
