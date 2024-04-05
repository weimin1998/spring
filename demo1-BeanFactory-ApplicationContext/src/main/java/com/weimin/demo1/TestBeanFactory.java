package com.weimin.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class TestBeanFactory {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        // 向beanFactory中添加一些常用的后处理器，后处理器是对beanFactory的拓展
        // 原始的beanFactory没有解析注解的能力，有了后处理器，就可以解析这些注解。
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        beanFactory.registerBeanDefinition("config", beanDefinition);


        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values()) {
            // 逐一执行beanFactoryPostProcessor
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

        // beanPostProcessor，针对bean的生命周期的各个阶段提供扩展；
        // 比如@Autowired @Resource
        for (BeanPostProcessor beanPostProcessor : beanFactory.getBeansOfType(BeanPostProcessor.class).values()) {
            // 逐一添加 beanPostProcessor
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 如无下面这行代码，观察bean2的构造时机
        // 准备好所有单例bean，而不是用到了才去创建
        beanFactory.preInstantiateSingletons();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(beanFactory.getBean(Bean1.class).getBean2());


    }

    @Configuration
    static class Config {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    static class Bean1 {
        private static final Logger log = LoggerFactory.getLogger(Bean1.class);
        public Bean1() {
            log.debug("构造Bean1()");
        }
        @Autowired
        private Bean2 bean2;
        public Bean2 getBean2() {
            return bean2;
        }
    }

    static class Bean2 {
        private static final Logger log = LoggerFactory.getLogger(Bean2.class);
        public Bean2() {
            log.debug("构造Bean2()");
        }
    }
}
