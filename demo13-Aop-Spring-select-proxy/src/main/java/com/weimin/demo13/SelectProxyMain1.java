package com.weimin.demo13;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * spring选择代理的方式
 */

public class SelectProxyMain1 {


    interface I1 {
        void foo();

        void bar();
    }

    static class Target1 implements I1 {

        @Override
        public void foo() {
            System.out.println("Target1 foo");
        }

        @Override
        public void bar() {
            System.out.println("Target1 bar");
        }
    }

    static class Target2 {

        public void foo() {
            System.out.println("Target2 foo");
        }

        public void bar() {
            System.out.println("Target2 bar");
        }
    }

    public static void main(String[] args) {

        // 1. 先准备一个切点pointcut, AspectJExpressionPointcut就是根据切点表达式来匹配方法
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // 2.设置切入点表达式
        // 下面这个表达式的含义是，只要目标类中有一个名为foo的方法，就表示匹配；
        pointcut.setExpression("execution(* foo())");
        // 3.准备一个通知advice，通知的逻辑就是将来要怎样对目标方法进行增强
        // MethodInterceptor 是环绕通知，是spring最常用的通知
        MethodInterceptor advice = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("before");
                Object proceed = invocation.proceed();
                System.out.println("after");
                return proceed;
            }
        };
        // 4.将切点和通知组合成一个切面 advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        // 5.创建一个目标类的对象
        Target1 target = new Target1();
        // 6.spring底层用ProxyFactory来创建目标类的代理对象
        ProxyFactory proxyFactory = new ProxyFactory();
        // 6.1指定目标类的对象
        proxyFactory.setTarget(target);
        // 6.2指定切面
        proxyFactory.addAdvisor(advisor);
        // 6.3指定这个目标类实现了什么接口（proxyFactory不能自己判断实现了什么接口，需要指定）
        proxyFactory.setInterfaces(target.getClass().getInterfaces());
        // 6.4 如果proxyTargetClass为true，则总是使用cglib来创建代理对象；
        proxyFactory.setProxyTargetClass(true);

        //7. 通过调用getProxy方法来创建代理对象；
        I1 proxy = (I1) proxyFactory.getProxy();

        System.out.println(proxy.getClass());

        proxy.foo();
        proxy.bar();
    }
}
