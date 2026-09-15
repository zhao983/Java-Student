package com.itjava.enumdemo;

//枚举类用enum修饰而不用class
public enum A {
    //枚举类第一行只能罗列名称，且这些名称都是常量，且每一个常量都会记住枚举类的一个对象
    X,Y,Z;  //用","隔开
/*
    //等效于
    public static final A X = new A();
    public static final A Y = new A();
    public static final A Z = new A();
*/

/*  //枚举类的构造器默认是私有的，不能对外创建对象
    private A() {
    }
    */
}
