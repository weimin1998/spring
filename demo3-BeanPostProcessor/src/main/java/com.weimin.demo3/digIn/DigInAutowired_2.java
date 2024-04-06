package com.weimin.demo3.digIn;

import com.weimin.demo3.beans.Bean1;
import com.weimin.demo3.beans.Bean2;
import com.weimin.demo3.beans.Bean5;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.StandardEnvironment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


// AutowiredAnnotationBeanPostProcessor 运行过程分析
public class DigInAutowired_2 {
    public static void main(String[] args) throws Throwable {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册两个单例对象
        // registerSingleton这个方法，这里直接把参数当是成品的bean放到单例池了，不会再走Bean的生命周期流程。
        beanFactory.registerSingleton("bean2", new Bean2());
        beanFactory.registerSingleton("bean5", new Bean5());
        // 解析@Value 中的 ${}
        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        beanFactory.addEmbeddedValueResolver(new StandardEnvironment()::resolvePlaceholders);

        // 以上是准备工作
        // ======================================================================================================================//

        // 下面是injectionMetadata.inject 这个方法中 如何根据类型从容器中找到bean

        // 先拿到标注了@Autowired、@Value的 属性和方法，也就是Field, Method
        // 封装成 DependencyDescriptor
        // 然后beanFactory就会调用doResolveDependency方法，从容器中找到相应的bean
        // 如果是属性，那么好办，直接从容器中找到对应属性类型的bean

        Field bean5 = Bean1.class.getDeclaredField("bean5");
        DependencyDescriptor dependencyDescriptor = new DependencyDescriptor(bean5, false);
        Object o = beanFactory.doResolveDependency(dependencyDescriptor, null, null, null);
        System.out.println(o);

        // 如果是方法，那么要根据方法参数类型去找。方法可能不止一个参数，要一个一个找
        // 当然。本例中，bean1的setBean2() 方法只有一个参数
        Method setBean2 = Bean1.class.getDeclaredMethod("setBean2", Bean2.class);
        DependencyDescriptor dependencyDescriptor1 = new DependencyDescriptor(new MethodParameter(setBean2, 0), false);
        Object o1 = beanFactory.doResolveDependency(dependencyDescriptor1, null, null, null);
        System.out.println(o1);

        Method setHome = Bean1.class.getDeclaredMethod("setHome", String.class);
        DependencyDescriptor dependencyDescriptor2 = new DependencyDescriptor(new MethodParameter(setHome, 0), false);
        Object o2 = beanFactory.doResolveDependency(dependencyDescriptor2, null, null, null);
        System.out.println(o2);
    }
}
