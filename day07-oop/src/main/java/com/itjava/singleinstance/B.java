package com.itjava.singleinstance;

//懒汉式单例
public class B {
    //定义一个私有的静态变量
    private static B b; //这里先不创建真正的对象

    //1.私有化构造器
    private B(){}

    public static B bObiect() {
        if (b == null) {
            b = new B();
        }
        return b;
    }
}
