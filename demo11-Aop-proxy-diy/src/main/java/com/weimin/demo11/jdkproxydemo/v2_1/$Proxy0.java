package com.weimin.demo11.jdkproxydemo.v2_1;

import com.weimin.demo11.jdkproxydemo.v2_1.JDKDemo.*;

// 模拟jdk的代理类
public class $Proxy0 implements Foo {

    InvocationHandler invocationHandler;

    public $Proxy0(InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }

    @Override
    public void foo() {
        invocationHandler.invoke();

        //第二版还有缺陷，如果接口中有多个方法呢？如果方法有返回值呢？
        //这样在调用目标方法时，就会出现问题，多个代理方法只能调用一个目标方法；
        //应该根据名字对应着调用；
    }

    @Override
    public int bar() {
        // 缺陷1：如果接口有返回值，invocationHandler要考虑
        invocationHandler.invoke();
        return 0;
    }
}