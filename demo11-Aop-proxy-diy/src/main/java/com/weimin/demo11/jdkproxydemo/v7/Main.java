package com.weimin.demo11.jdkproxydemo.v7;

import com.weimin.demo11.jdkproxydemo.v7.JDKDemo.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        $Proxy0 $Proxy0 = new $Proxy0(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                // 增强
                System.out.println("before");
                // 调用目标方法
                return method.invoke(new Target(),args);
            }
        });
        $Proxy0.foo();
        $Proxy0.bar();
    }
}
