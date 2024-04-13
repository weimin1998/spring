package com.weimin.demo11.jdkproxydemo.v7;

import com.weimin.demo11.jdkproxydemo.v7.JDKDemo.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

// 模拟jdk的代理类
public class $Proxy0 extends Proxy implements Foo {

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


    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    @Override
    public void foo() {
        try {
            h.invoke(this, foo,new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public int bar() {
        try {
            return (int) h.invoke(this, bar,new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}