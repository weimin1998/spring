package com.weimin.demo9;


import com.weimin.demo9.service.MyService;

public class AspectjMain1 {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//
//        applicationContext.register(ConfigAop.class);
//
//        applicationContext.refresh();

        // aspectj编译器在编译阶段修改class文件，因此和spring就没关系了
        MyService bean = new MyService();

        System.out.println(bean.getClass());
        bean.foo();
    }
}
