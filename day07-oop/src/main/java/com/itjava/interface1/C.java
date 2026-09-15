package com.itjava.interface1;

//JDK8以前，抽象类只能定义常量和抽象方法
//一个类可以同时实现多个接口
//实现接口的类被叫做实现类
public class C implements A, B {

    //一定要重写全部抽象方法(接口中默认全是抽象方法)，否者必须定义成抽象类
    @Override
    public void go() {
        System.out.println("重写了go方法");
    }

    @Override
    public void run() {
        System.out.println("重写了run方法");

    }
}
