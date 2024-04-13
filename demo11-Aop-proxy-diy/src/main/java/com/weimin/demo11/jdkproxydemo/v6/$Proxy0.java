package com.weimin.demo11.jdkproxydemo.v6;

import com.weimin.demo11.jdkproxydemo.v6.JDKDemo.*;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

// 模拟jdk的代理类
public class $Proxy0 implements Foo {

    static Method foo;
    static Method bar;

    static {
        try {
            foo = Foo.class.getMethod("foo");
            bar = Foo.class.getMethod("bar");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    InvocationHandler invocationHandler;

    public $Proxy0(InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
    }

    @Override
    public void foo() {
        try {
            invocationHandler.invoke(this, foo,new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public int bar() {
        try {
            return (int) invocationHandler.invoke(this, bar,new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}