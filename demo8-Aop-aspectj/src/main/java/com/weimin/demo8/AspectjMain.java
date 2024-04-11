package com.weimin.demo8;


import com.weimin.demo8.config.ConfigAop;
import com.weimin.demo8.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectjMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ConfigAop.class);

        applicationContext.refresh();

        MyService bean = applicationContext.getBean(MyService.class);

        System.out.println(bean.getClass());
        bean.foo();
    }
}
