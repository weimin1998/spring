package com.weimin.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

@SpringBootApplication
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type= FilterType.REGEX, pattern = "com.weimin.demo1.TestApplicationImpl.WebConfig") })
public class TestApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestApplication.class, args);

        // applicationContext的功能


        // 国际化
        System.out.println(applicationContext.getMessage("hi", null, Locale.CHINA));
        System.out.println(applicationContext.getMessage("hi", null, Locale.ENGLISH));
        System.out.println(applicationContext.getMessage("hi", null, Locale.JAPANESE));

        // resource
        Resource resource = applicationContext.getResource("classpath:application.properties");
        System.out.println(resource);

        Resource[] resources = applicationContext.getResources("classpath*:META-INF/spring.factories");
        for (Resource resource1 : resources) {
            System.out.println(resource1);
        }

        // environment
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        System.out.println(environment.getProperty("JAVA_HOME"));
        System.out.println(environment.getProperty("java_home"));
        System.out.println(environment.getProperty("server.port"));

        applicationContext.close();
    }

}
