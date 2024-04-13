package com.weimin.demo11.jdkproxydemo.v2_1;

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

    interface InvocationHandler{
        void invoke();
    }

}