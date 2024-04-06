package com.weimin.demo3.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// 演示各种注解的解析，是由哪些bean后处理器解析的
public class Bean1 {

    private Bean2 bean2;

    @Autowired
    public void setBean2(Bean2 bean2) {
        System.out.println("@Autowired生效："+ bean2);
        this.bean2 = bean2;
    }

    private Bean3 bean3;

    @Resource
    public void setBean3(Bean3 bean3) {
        System.out.println("@Resource生效："+ bean3);
        this.bean3 = bean3;
    }

    private String home;

    @Autowired
    public void setHome(@Value("${JAVA_HOME}") String home) {
        System.out.println("@Value生效："+ home);
        this.home = home;
    }

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("@PreDestroy");
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "bean2=" + bean2 +
                ", bean3=" + bean3 +
                ", home='" + home + '\'' +
                '}';
    }


    // 这个属性，其他的例子中都没有用到，可忽略
    // 只需要在 DigInAutowired_2 中 注意下就好
    @Autowired(required = false)
    private Bean5 bean5;
}
