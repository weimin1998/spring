package com.weimin.demo3.digIn;

import com.weimin.demo3.beans.Bean1;
import com.weimin.demo3.beans.Bean2;
import com.weimin.demo3.beans.Bean5;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.env.StandardEnvironment;


// AutowiredAnnotationBeanPostProcessor 运行过程分析
public class DigInAutowired {
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


        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
        postProcessor.setBeanFactory(beanFactory);

        Bean1 bean1 = new Bean1();
        System.out.println("@Autowired生效之前： " + bean1);

        // postProcessProperties这个方法内，解析@Autowired, @Value
        // 第一个参数，表示要手动给属性赋值，比如初学spring时，使用xml手动给属性赋值，参考spring.xml。现在不用这种方法，了解一下即可。

        // 这个方法做的事情
        // 1.找到bean1中，哪些属性，哪些方法上加了@Autowired，将这些信息封装成InjectionMetadata；
        // 2.从spring容器中找到需要注入的对象，利用反射给这些属性、方法参数赋值；
        postProcessor.postProcessProperties(null, bean1, "bean1");

        System.out.println("@Autowired生效之后： " + bean1);

        // 下一个例子中，我们手动调用一下postProcessProperties中的两个子方法，来看看细节

    }
}
