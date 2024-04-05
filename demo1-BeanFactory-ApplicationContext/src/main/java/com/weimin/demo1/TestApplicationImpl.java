package com.weimin.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

// ApplicationContext的实现
public class TestApplicationImpl {

    public static void main(String[] args) throws IOException {
        // 1.基于类路径下的配置文件
        //testClassPathXmlApplicationContext();

        // 2.基于文件系统的配置文件
        //testFileSystemXmlApplicationContext();

        // 3.基于配置类
        //testAnnotationConfigApplicationContext();

        // 4.基于配置类，支持web环境
        testAnnotationConfigServletWebServerApplicationContext();
    }

    private static void testAnnotationConfigServletWebServerApplicationContext() {
        ApplicationContext annotationConfigServletWebServerApplicationContext = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
        // http://localhost:8080/hello
    }

    private static void testAnnotationConfigApplicationContext() {
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(annotationConfigApplicationContext.getBean(Bean3.class));
    }

    private static void testFileSystemXmlApplicationContext() {
        ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("F:\\javacode\\spring\\demo1-BeanFactory-ApplicationContext\\src\\main\\resources\\spring.xml");
        System.out.println(fileSystemXmlApplicationContext.getBean(Bean4.class));
    }

    private static void testClassPathXmlApplicationContext() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(classPathXmlApplicationContext.getBean(Bean3.class));
    }


    @Configuration
    static class Config{
        @Bean
        public Bean3 bean3(){
            return new Bean3();
        };

    }

    static class Bean3{}
    static class Bean4{}


    @Configuration
    static class WebConfig{

        @Bean
        public ServletWebServerFactory servletWebServerFactory(){
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public DispatcherServlet dispatcherServlet(){
            return new DispatcherServlet();
        }

        @Bean
        public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet){
            return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
        }

        // bean的name如果是以斜杠开头，则可以识别为控制器的访问路径
        @Bean("/hello")
        public Controller controller(){
            return new Controller() {
                public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
                    response.getWriter().write("hello world!");
                    return null;
                }
            };
        }

    }
}
