package com.weimin.demo14;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.transaction.annotation.Transactional;

/**
 * 切点匹配，根据注解
 */
public class Main2 {

    static class Target1 {

        @Transactional
        public void foo() {
            System.out.println("Target1 foo");
        }

        public void bar() {
            System.out.println("Target1 bar");
        }
    }


    // 如果希望根据方法上的注解来进行增强呢，比如foo方法上标注了@Transactional；
    public static void main(String[] args) throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        // 根据注解匹配
        pointcut.setExpression("@annotation(org.springframework.transaction.annotation.Transactional)");

        System.out.println(pointcut.matches(Target1.class.getDeclaredMethod("bar"), Target1.class));// false
        System.out.println(pointcut.matches(Target1.class.getDeclaredMethod("foo"), Target1.class));// true

        // 那么@Transactional注解的原理是怎样的呢？是上面这种方法嘛？其实不是！
    }
}
