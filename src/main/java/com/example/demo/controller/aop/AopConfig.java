package com.example.demo.controller.aop;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020-07-16 15:01
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AopConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }

}
