package com.weimin.demo11.jdkproxydemo.v2_1;

import com.weimin.demo11.jdkproxydemo.v2_1.JDKDemo.*;
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

        // 缺陷2：多个代理方法只能调用一个目标方法；
        $Proxy0.bar();
    }
}
