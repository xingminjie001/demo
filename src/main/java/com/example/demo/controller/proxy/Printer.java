package com.example.demo.controller.proxy;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/19 14:49
 */
public class Printer implements IPrinter {
    @Override
    public void print(){
        System.out.println("我要被代理！");
    }
}
