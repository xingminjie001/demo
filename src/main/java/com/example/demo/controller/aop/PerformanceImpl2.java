package com.example.demo.controller.aop;

import org.springframework.stereotype.Service;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/19 14:49
 */
@Service("p2")
public class PerformanceImpl2 implements Performance {
    @Override
    public void perform(){
        System.out.println("开始表演11111！");
    }
}
