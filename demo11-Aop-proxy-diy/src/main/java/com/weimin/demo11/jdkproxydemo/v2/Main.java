package com.weimin.demo11.jdkproxydemo.v2;

import com.weimin.demo11.jdkproxydemo.v2.JDKDemo.*;
public class Main {
    public static void main(String[] args) {
        $Proxy0 $Proxy0 = new $Proxy0(new InvocationHandler() {
            @Override
            public void invoke() {
                // 增强
                System.out.println("before");

                // 调用目标方法
                new Target().foo();
            }
        });
        $Proxy0.foo();
    }
}
