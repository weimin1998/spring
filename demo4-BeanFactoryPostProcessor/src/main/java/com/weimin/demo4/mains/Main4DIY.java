package com.weimin.demo4.mains;

import com.weimin.demo4.DIYConfig;
import com.weimin.demo4.myBeanFactoryPostProcessor.ComponentScanBeanFactoryPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

public class Main4DIY {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("DIYConfig", DIYConfig.class);


        // 模拟 ConfigurationClassPostProcessor 包扫描，解析@ComponentScan，解析@Component，以及它的派生注解
        context.registerBean(ComponentScanBeanFactoryPostProcessor.class);

        context.refresh();

        System.out.println("======================================================================================================================");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("======================================================================================================================");

        context.close();
    }
}
