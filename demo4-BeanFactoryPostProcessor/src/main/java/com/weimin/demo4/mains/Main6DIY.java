package com.weimin.demo4.mains;

import com.weimin.demo4.DIYConfig;
import com.weimin.demo4.myBeanFactoryPostProcessor.MapperPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

// 模拟MapperScannerConfigurer
public class Main6DIY {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("DIYConfig", DIYConfig.class);

        // 模拟MapperScannerConfigurer底层需要解析@Import，所以加入这个
        // 解析 @ComponentScan @Bean @Import @ImportResource
        context.registerBean(ConfigurationClassPostProcessor.class);

        // 模拟MapperScannerConfigurer
        context.registerBean(MapperPostProcessor.class);

        context.refresh();

        System.out.println("======================================================================================================================");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("======================================================================================================================");

        context.close();
    }
}
