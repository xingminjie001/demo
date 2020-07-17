package com.example.demo.controller.proxy;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/8 18:31
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Printer target = new Printer();
        Class<?>[] a = target.getClass().getInterfaces();
        //传入目标对象
        //目的：1.根据它实现的接口生成代理对象 2.代理对象调用目标对象方法
        IPrinter iPrinterProxy = (IPrinter) getProxy(target);
        iPrinterProxy.print();
        String aa = "https://lc-static.rezenhotels.com/mob-hotel/mob_lc01_1592819337505jkcI.png,https://lc-static.rezenhotels.com/mob-hotel/mob_lc01_15928193437646uF5.png,https://lc-static.rezenhotels.com/mob-hotel/mob_lc";
        System.out.println(aa.trim().length());
    }
    private static Object getProxy(final Object target) throws Exception{
        //参数1：随便找个类加载器给它， 参数2：目标对象实现的接口，让代理对象实现相同接口
        Class proxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader()
                ,target.getClass().getInterfaces());
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+"方法开始执行...");
                Object result = method.invoke(target, args);
                System.out.println(method.getName()+"方法执行结束...");
                return result;
            }
        });
        return proxy;
    }
}
