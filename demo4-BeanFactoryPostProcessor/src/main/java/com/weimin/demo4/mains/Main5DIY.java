package com.weimin.demo4.mains;

import com.weimin.demo4.DIYConfig;
import com.weimin.demo4.myBeanFactoryPostProcessor.BeanAnnotationBeanFactoryPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class Main5DIY {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("DIYConfig", DIYConfig.class);


        // 模拟 ConfigurationClassPostProcessor解析@Bean
        context.registerBean(BeanAnnotationBeanFactoryPostProcessor.class);

        context.refresh();

        System.out.println("======================================================================================================================");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("======================================================================================================================");

        context.close();
    }
}
