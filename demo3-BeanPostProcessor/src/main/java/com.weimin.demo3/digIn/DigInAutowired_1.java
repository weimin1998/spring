package com.weimin.demo3.digIn;

import com.weimin.demo3.beans.Bean1;
import com.weimin.demo3.beans.Bean2;
import com.weimin.demo3.beans.Bean5;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.env.StandardEnvironment;

import java.lang.reflect.Method;


// AutowiredAnnotationBeanPostProcessor 运行过程分析
public class DigInAutowired_1 {
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

        // 手动调用postProcessProperties中的子方法
        // 使用反射调用
        Method findAutowiringMetadata = AutowiredAnnotationBeanPostProcessor.class.getDeclaredMethod("findAutowiringMetadata", String.class, Class.class, PropertyValues.class);
        findAutowiringMetadata.setAccessible(true);

        // 调用子方法 findAutowiringMetadata
        // 获取 Bean1 中，哪些属性、方法上标注了@Autowired, @Value
        InjectionMetadata injectionMetadata = (InjectionMetadata) findAutowiringMetadata.invoke(postProcessor, "bean", Bean1.class, null);

        // InjectionMetadata没有重新toString，可以打断点。查看哪些属性、方法上标注了@Autowired, @Value
        System.out.println(injectionMetadata);

        // 调用子方法 injectionMetadata.inject
        // 这个方法中，会从spring容器中根据类型找到给对象，给需要注入的属性、方法参数赋值
        injectionMetadata.inject(bean1, "bean1", null);

        System.out.println("@Autowired生效之后： " + bean1);

        // injectionMetadata.inject中，如何根据类型找到，并且赋值呢，参考下一个例子
    }
}
