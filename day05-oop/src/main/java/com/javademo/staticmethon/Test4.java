package com.javademo.staticmethon;

public class Test4 {
    public static String name = "张三";
    private int age = 18;

    public static void main(String[] args) {
        printHelloWorld();

    }

    public static void printHelloWorld() {
        //静态方法中可以直接访问静态成员，不可以直接访问实例成员。
        System.out.println(name);
//      System.out.println(age);  报错

    }

    //实例方法中既可以直接访问静态成员，也可以直接访问实例成员。
    public void printHello() {
        //静态方法中可以直接访问静态成员，不可以直接访问实例成员。
        System.out.println(name);
        System.out.println(age);

    }

    //实例方法中可以出现this关键字，静态方法中不可以出现this关键字的。
    public static void printTest1(int age) {
        //this.age=age;  报错

    }

    public void printTest2(int age) {
        this.age = age;

    }

}
