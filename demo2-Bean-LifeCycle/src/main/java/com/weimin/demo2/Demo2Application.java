package com.weimin.demo2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Demo2Application.class, args);

        applicationContext.close();

        /*

2024-04-06 10:10:37.430  INFO 8084 --- [           main] com.weimin.demo2.MyBeanPostProcessor     : <<<<< 实例化之前，这里返回的对象会替换原本的bean
2024-04-06 10:10:37.434  INFO 8084 --- [           main] com.weimin.demo2.LifeCycleBean           : LifeCycleBean 构造
2024-04-06 10:10:37.442  INFO 8084 --- [           main] com.weimin.demo2.MyBeanPostProcessor     : <<<<< 实例化之后，这里如果返回false，则会跳过依赖注入
2024-04-06 10:10:37.443  INFO 8084 --- [           main] com.weimin.demo2.MyBeanPostProcessor     : <<<<< 依赖注入阶段执行，比如@Autowired @Resource @Value
2024-04-06 10:10:37.452  INFO 8084 --- [           main] com.weimin.demo2.LifeCycleBean           : 依赖注入 C:\Program Files\Java\jdk1.8.0_271
2024-04-06 10:10:37.455  INFO 8084 --- [           main] com.weimin.demo2.MyBeanPostProcessor     : <<<<< 初始化之前，这里返回的对象会替换原本的bean，比如@PostConstruct @ConfigurationProperties
2024-04-06 10:10:37.455  INFO 8084 --- [           main] com.weimin.demo2.LifeCycleBean           : LifeCycleBean 初始化
2024-04-06 10:10:37.455  INFO 8084 --- [           main] com.weimin.demo2.MyBeanPostProcessor     : <<<<< 初始化之后，这里返回的对象会替换原本的bean，比如代理增强
2024-04-06 10:10:40.387  INFO 8084 --- [           main] com.weimin.demo2.MyBeanPostProcessor     : <<<<< 销毁之前
2024-04-06 10:10:40.388  INFO 8084 --- [           main] com.weimin.demo2.LifeCycleBean           : LifeCycleBean 销毁

         */
    }
}
