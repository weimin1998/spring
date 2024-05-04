package com.weimin.demo14;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.transaction.annotation.Transactional;

/**
 * 切点匹配，根据方法
 */
public class Main1 {

    static class Target1 {

        @Transactional
        public void foo() {
            System.out.println("Target1 foo");
        }

        public void bar() {
            System.out.println("Target1 bar");
        }
    }


    // 如果希望，foo方法执行时，不需要增强，而bar方法执行时，需要增强；也就是根据方法名来匹配；
    public static void main(String[] args) throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // 切点表达式，根据方法的全限定名匹配；
        pointcut.setExpression("execution(* bar())");

        // 调用切点的matches方法，判断是否匹配
        System.out.println(pointcut.matches(Target1.class.getDeclaredMethod("bar"), Target1.class));// true
        System.out.println(pointcut.matches(Target1.class.getDeclaredMethod("foo"), Target1.class));// false
    }
}
