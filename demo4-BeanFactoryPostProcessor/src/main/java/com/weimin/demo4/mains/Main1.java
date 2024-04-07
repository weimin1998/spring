package com.weimin.demo4.mains;

import com.weimin.demo4.Config;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("config", Config.class);

        // 加载Config这个配置类
        // 在这个配置类中
        // 1.开启了组件扫描  @ComponentScan("com.weimin.demo4.component")，扫描Bean2。
        // 2.使用@Bean注解 加入Bean1, SqlSessionFactoryBean, DruidDataSource
        // 因此容器启动后，应该有这些bean

        // 但是启动后发现只有一个Config本身
        // 这是因为@ComponentScan 和 @Bean注解都没有被解析
        // 而解析这些注解需要 ConfigurationClassPostProcessor
        // 下个例子演示

        context.refresh();

        System.out.println("======================================================================================================================");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("======================================================================================================================");

        context.close();
    }
}
