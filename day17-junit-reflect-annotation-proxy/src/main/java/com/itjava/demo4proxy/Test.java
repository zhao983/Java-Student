package com.itjava.demo4proxy;

public class Test {
    //目标：创建代理对象
    public static void main(String[] args) {
        //1.追捕一个明星对象，设计明星类
        Star s= new Star("张三");

        //2.为明星创建一个专属于它的代理对象 用工具类来负责创建代理对象
        StarService proxy = ProxyUtil.createProxy(s);
        proxy.sing();
        String dance = proxy.dance("街舞");
        System.out.println(dance);

    }
}
