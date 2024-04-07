package com.weimin.demo5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MyConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyConfig.class);

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        logger.info("Autowired 注入 applicationContext: " + applicationContext);
    }

    @PostConstruct
    public void init(){
        logger.info("初始化");
    }

    // 直接使用@Bean在配置类中配置BeanFactoryPostProcessor，会导致@Autowired, @Resource and @PostConstruct 等依赖注入失效
    @Bean
    public BeanFactoryPostProcessor processor1(){
        return beanFactory -> logger.info("在配置类中，配置BeanFactoryPostProcessor， processor1");
    }
    // 下面的日志中，spring也提供了提示

    /*

16:58:59.207 [main] DEBUG org.springframework.context.support.GenericApplicationContext - Refreshing org.springframework.context.support.GenericApplicationContext@6996db8
16:58:59.253 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.ConfigurationClassPostProcessor'
16:58:59.561 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'processor1'
16:58:59.561 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'myConfig'
16:58:59.567 [main] INFO org.springframework.context.annotation.ConfigurationClassEnhancer - @Bean method MyConfig.processor1 is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface. This will result in a failure to process annotations such as @Autowired, @Resource and @PostConstruct within the method's declaring @Configuration class. Add the 'static' modifier to this method to avoid these container lifecycle issues; see @Bean javadoc for complete details.
16:58:59.590 [main] INFO com.weimin.demo5.MyConfig - 在配置类中，配置BeanFactoryPostProcessor， processor1
16:58:59.592 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor'
16:58:59.595 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.CommonAnnotationBeanPostProcessor'
16:58:59.643 [main] DEBUG org.springframework.context.support.GenericApplicationContext - Closing org.springframework.context.support.GenericApplicationContext@6996db8, started on Sun Apr 07 16:58:59 CST 2024


     */
}
