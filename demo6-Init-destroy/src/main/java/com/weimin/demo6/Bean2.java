package com.weimin.demo6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bean2 implements DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(Bean2.class);

    public void destroyMethod(){
        logger.info(">>>>>>>>>>>>>>>> @Bean(destroyMethod = \"destroyMethod\")方式的销毁");
    }

    @PreDestroy
    public void destroyPreDestroy(){
        logger.info(">>>>>>>>>>>>>>>> @PreDestroy 注解方式的销毁");
    }

    @Override
    public void destroy() throws Exception {
        logger.info(">>>>>>>>>>>>>>>> 实现DisposableBean 接口方式的销毁");
    }
}
