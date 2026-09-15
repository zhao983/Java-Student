package com.itjava.interface1;

//认识接口：接口是用来被类实现的
public class Test {
    public static void main(String[] args) {
        //接口也不能创建对象
//        A a = new A();  报错

        C c = new C();
        System.out.println(c.NAME);
        c.go();
        c.run();
    }



}

