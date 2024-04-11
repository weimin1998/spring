package com.weimin.demo9.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    final public void foo(){
        System.out.println("service foo");
        bar();
    }

    public void bar(){
        System.out.println("service bar");
    }
}
