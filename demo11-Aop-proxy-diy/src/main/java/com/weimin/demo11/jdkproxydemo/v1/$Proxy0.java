package com.weimin.demo11.jdkproxydemo.v1;

import com.weimin.demo11.jdkproxydemo.v1.JDKDemo.*;

// 模拟jdk的代理类
public class $Proxy0 implements Foo {

    @Override
    public void foo() {
        // 增强
        System.out.println("before");

        // 调用目标方法
        new Target().foo();

        //但是jdk在生成代理类的字节码时，不可能像这样把增强的逻辑和调用目标方法的逻辑写死在代理类的字节码中（这样就成静态代理了），
        //因为jdk不知道要怎么增强，以及是否调用目标方法（比如在鉴权的时候，不满足鉴权的条件，就不放行）
        //而是把这两段逻辑交给开发人员自己定义；
        // 这就是为什么jdk动态代理提供了 InvocationHandler 接口

        // 见v2
    }
}