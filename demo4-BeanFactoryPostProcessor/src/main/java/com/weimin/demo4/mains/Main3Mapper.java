package com.weimin.demo4.mains;

import com.weimin.demo4.Config;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class Main3Mapper {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("config", Config.class);

        // MapperScannerConfigurer, 也是beanFactoryPostProcessor，是mybatis提供的
        // 作用是扫描mapper
        context.registerBean(MapperScannerConfigurer.class, bd -> {bd.getPropertyValues().add("basePackage","com.weimin.demo4.mapper");});
        // MapperScannerConfigurer 也会添加常用的后处理器，比如ConfigurationClassPostProcessor
        // 因此，可以看到，不仅mapper接口被扫描到了，其他的bean也被扫描到了
        // 这里只需要关心mapper接口是否被扫描

        context.refresh();

        System.out.println("======================================================================================================================");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("======================================================================================================================");
        context.close();
    }
}
