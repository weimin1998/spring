package com.weimin.demo6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class Bean1 implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(Bean1.class);
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info(">>>>>>>>>>>>>>>> 实现InitializingBean 接口方式的初始化");
    }

    public void initMethod(){
        logger.info(">>>>>>>>>>>>>>>> @Bean(initMethod = \"initMethod\")方式的初始化");
    }


    @PostConstruct
    public void init(){
        logger.info(">>>>>>>>>>>>>>>> @PostConstruct 注解方式的初始化");
    }
}
