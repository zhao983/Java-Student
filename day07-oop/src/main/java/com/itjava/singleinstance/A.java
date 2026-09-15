package com.itjava.singleinstance;

public class A {
    //2.定义一个静态变量，用于基本类的唯一对象
    //public static A a=new A();  这样设计的问题是可能在Test测试类中 A a = null;会让这个唯一对象为空
    //两种解决方法
    //public static final A a=new A(); 用final修饰，这样就不能再赋值
    private static A a = new A();  //私有化该对象，这样就不能再被外部访问赋值
    //这样的话要加get方法用来返回a

    //1.要先私有化构造器，放置创建新对象
    private A() {
    }

    public static A getObject() {
        return a;
    }


}
//这种叫饿汉式单例，拿对象的时候就对象已经创建好了