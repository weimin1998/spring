package com.weimin.demo11.jdkproxydemo.v1;

public class JDKDemo {

    interface Foo{
        void foo();
    }
    static final class Target implements Foo {

        @Override
        public void foo() {
            System.out.println("target foo");
        }
    }

}