package com.weimin.demo11.jdkproxydemo.v4;

import com.weimin.demo11.jdkproxydemo.v4.JDKDemo.*;

import java.lang.reflect.Method;

// 模拟jdk的代理类
public class $Proxy0 implements Foo {

    InvocationHandler invocationHandler;

    public $Proxy0(InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }

    @Override
    public void foo() {
        Method foo = null;
        try {
            foo = Foo.class.getMethod("foo");
            invocationHandler.invoke(this, foo,new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int bar() {
        Method bar = null;
        try {
            bar = Foo.class.getMethod("bar");
            return (int) invocationHandler.invoke(this, bar,new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}