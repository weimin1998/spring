package com.weimin.demo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class MyController {

    @Lazy
    @Autowired
    private BeanForRequest beanForRequest;
    @Lazy
    @Autowired
    private BeanForSession beanForSession;
    @Lazy
    @Autowired
    private BeanForApplication beanForApplication;

    @GetMapping(value = "/test",produces = "text/html")
    public String hello(HttpServletRequest request, HttpSession session){
        ServletContext servletContext = request.getServletContext();

        return "<ul>" +
                "<li>" + "request scope" + beanForRequest + "</li>" +
                "<li>" + "session scope" + beanForSession + "</li>" +
                "<li>" + "application scope" + beanForApplication + "</li>" +
                "</ul>";
    }
}
