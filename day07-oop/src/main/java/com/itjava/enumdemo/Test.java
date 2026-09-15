package com.itjava.enumdemo;

//认识枚举类
public class Test {
    public static void main(String[] args) {
        A a1 = A.X;
        System.out.println(a1);
        //输出"X"，因为枚举类中自动重写了toString方法
        A a2 = A.Y;

        //枚举类中提供了几个方法
        System.out.println(a1.name());
        System.out.println(a1.ordinal()); //拿索引
        System.out.println(a2.ordinal());

    }
}
