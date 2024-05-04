package com.weimin.demo14;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 *  Transactional注解，不仅可以加在方法上，还可以加在类上，甚至接口上；
 */
public class TransactionalMain {
    static class Target1 {

        @Transactional
        public void foo() {
            System.out.println("Target1 foo");
        }

        public void bar() {
            System.out.println("Target1 bar");
        }
    }


    @Transactional
    static class Target2 {

        public void foo() {
            System.out.println("Target2 foo");
        }

        public void bar() {
            System.out.println("Target2 bar");
        }
    }


    @Transactional
    interface I3{
        void foo();
    }
    static class Target3 implements I3{

        @Override
        public void foo() {
            System.out.println("Target3 foo");
        }

        public void bar() {
            System.out.println("Target3 bar");
        }
    }


    // 上一篇中的AspectJExpressionPointcut，它的切点表达式，只能匹配方法的信息，不能匹配类和接口的信息；
    //所以这里不能用它了；
    //得用StaticMethodMatcherPointcut；
    // 这里的StaticMethodMatcherPointcut和上篇的AspectJExpressionPointcut都实现了MethodMatcher接口，matches方法，就是这个接口提供的；
    public static void main(String[] args) throws NoSuchMethodException {
        StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                // MergedAnnotations工具类。也可以自己利用反射api判断
                MergedAnnotations annotations = MergedAnnotations.from(method);

                if(annotations.isPresent(Transactional.class)){
                    // 方法上是否有注解
                    return true;
                }


                // from(class)默认只会找本类；
                // annotations = MergedAnnotations.from(targetClass);
                // 指定查找策略，TYPE_HIERARCHY，不仅查找本类，还会查找父类，以及实现的接口上是否有Transactional
                annotations = MergedAnnotations.from(targetClass, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);

                if(annotations.isPresent(Transactional.class)){
                    // 类上、类实现的接口上是否有注解
                    return true;
                }
                return false;
            }
        };


        System.out.println(pointcut.matches(Target1.class.getDeclaredMethod("foo"), Target1.class)); // true
        System.out.println(pointcut.matches(Target1.class.getDeclaredMethod("bar"), Target1.class)); // false

        System.out.println(pointcut.matches(Target2.class.getDeclaredMethod("foo"), Target2.class)); // true
        System.out.println(pointcut.matches(Target2.class.getDeclaredMethod("bar"), Target2.class)); // true

        System.out.println(pointcut.matches(Target3.class.getDeclaredMethod("foo"), Target3.class)); // true
        System.out.println(pointcut.matches(Target3.class.getDeclaredMethod("bar"), Target3.class)); // true

    }
}
