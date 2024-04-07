package com.weimin.demo6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo6Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Demo6Application.class, args);
        applicationContext.close();

        // 三种初始化方法的执行顺序：
        // >>>>>>>>>>>>>>>> @PostConstruct 注解方式的初始化
        // >>>>>>>>>>>>>>>> 实现InitializingBean 接口方式的初始化
        // >>>>>>>>>>>>>>>> @Bean(initMethod = "initMethod")方式的初始化

        // 三种销毁方法的执行顺序
        // >>>>>>>>>>>>>>>> @PreDestroy 注解方式的销毁
        // >>>>>>>>>>>>>>>> 实现DisposableBean 接口方式的销毁
        // >>>>>>>>>>>>>>>> @Bean(destroyMethod = "destroyMethod")方式的销毁
    }

    @Bean(initMethod = "initMethod")
    public Bean1 bean1(){
        return new Bean1();
    }

    @Bean(destroyMethod = "destroyMethod")
    public Bean2 bean2(){
        return new Bean2();
    }


}
