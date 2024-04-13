package com.weimin.demo11.cglibdemo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import com.weimin.demo11.cglibdemo.CGLIBDemo.*;
public class Main {
    public static void main(String[] args) {
        Target target = new Target();
        CGLIBProxy cglibProxy = new CGLIBProxy();
        cglibProxy.setMethodInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                return methodProxy.invoke(target, objects);
            }
        });

        cglibProxy.save();
        cglibProxy.save(1);
        cglibProxy.save(2L);
    }
}
