package com.example.demo.controller.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020-07-16 14:36
 */
@Controller
public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Performance performance = context.getBean("p1",Performance.class);
        performance.perform();
        context.close();

    }
}
