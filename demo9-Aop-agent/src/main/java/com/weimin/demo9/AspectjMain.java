package com.weimin.demo9;


import com.weimin.demo9.config.ConfigAop;
import com.weimin.demo9.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// skywalking也是用的java agent
// 加入虚拟机参数
// -javaagent:C:/Users/Administrator/.m2/repository/org/aspectj/aspectjweaver/1.9.5/aspectjweaver-1.9.5.jar
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
