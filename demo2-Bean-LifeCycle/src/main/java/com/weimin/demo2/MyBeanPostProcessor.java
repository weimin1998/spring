package com.weimin.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(MyBeanPostProcessor.class);
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycleBean")){
            log.info("<<<<< 销毁之前");
        }
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.equals("lifeCycleBean")){
            log.info("<<<<< 实例化之前，这里返回的对象会替换原本的bean");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycleBean")){
            log.info("<<<<< 实例化之后，这里如果返回false，则会跳过依赖注入");
        }

        return true;
    }

    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycleBean")){
            log.info("<<<<< 依赖注入阶段执行，比如@Autowired @Resource @Value");
        }
        return pvs;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycleBean")){
            log.info("<<<<< 初始化之前，这里返回的对象会替换原本的bean，比如@PostConstruct @ConfigurationProperties");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifeCycleBean")){
            log.info("<<<<< 初始化之后，这里返回的对象会替换原本的bean，比如代理增强");
        }
        return bean;
    }
}
