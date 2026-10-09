package com.itjava.demo4proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    //创建一个明星代理的对象返回
    public static StarService createProxy(Star s){
        /**
         * 参数一：用于执行用哪个类加载器去加载生成的代理类。
         * 参数二：用于指定代理类需要实现的接口： 明星类实现了哪些接口，代理类就实现哪些接口
         * 参数三：用于指定代理类需要如何执行方法。
         */

        StarService proxy = (StarService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), s.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 用来声明代理对象要干的事情。
                    // 参数一： proxy接收到代理对象本身（暂时用处不大）
                    // 参数二： method代表正在被代理的方法
                    // 参数三： args代表正在被代理的方法的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        if("sing".equals(name)){
                            System.out.println("明星的唱歌方法");
                        }

                        if("dance".equals(name)){
                            System.out.println("明星的跳舞方法");
                        }

                        // 真正干活（把真正的明星对象叫过来正式干活）
                        // 找真正的明星对象来执行被代理的行为：method方法  两个参数: 代理的对象和方法传过来的参数
                        Object obj = method.invoke(s,args);
                        return obj;
                    }
                });
        return proxy;
    }
}
