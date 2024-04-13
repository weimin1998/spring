package com.weimin.demo11.jdkproxydemo.v7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JDKDemo {

    interface Foo{
        void foo();

        int bar();
    }
    static final class Target implements Foo {

        @Override
        public void foo() {
            System.out.println("target foo");
        }

        @Override
        public int bar() {
            System.out.println("target bar");
            return 0;
        }
    }

//    interface InvocationHandler{
//        Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
//    }

}