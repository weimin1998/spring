package com.weimin.demo5;

import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {

        /*
        *
        *
        *
        *
        * */

        GenericApplicationContext context = new GenericApplicationContext();

        context.registerBean("MyBean", MyBean.class);

        context.refresh();
        context.close();
    }

}
