package com.weimin.demo3.mains;

import com.weimin.demo3.beans.Bean4;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class Main5 {
    public static void main(String[] args) {
        // GenericApplicationContext是一个【干净】的容器，没有任何的后处理器
        // 因此 bean1 中的注解都不会被解析
        // 后面的测试Main中，会逐个添加beanPostProcessor
        GenericApplicationContext context = new GenericApplicationContext();

        context.registerBean("bean4", Bean4.class);

        // 解析@ConfigurationProperties，使用 ConfigurationPropertiesBindingPostProcessor 这个bean后处理器
        // 这里的后处理器是spring boot提供的，解析@ConfigurationProperties
        // 调用register 把自己注册到容器
        ConfigurationPropertiesBindingPostProcessor.register(context.getDefaultListableBeanFactory());

        context.refresh();

        System.out.println(context.getBean("bean4"));

        context.close();
    }
}
