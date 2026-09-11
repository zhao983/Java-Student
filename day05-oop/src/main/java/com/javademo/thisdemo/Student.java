package com.javademo.thisdemo;

public class Student {
    //成员变量
    String name;

    //this是一个变量，可以用在方法中，来拿到当前的变量地址
    //哪个对象调用这个方法，他就拿哪个对象
    public void printThis() {
        System.out.println(this);
        System.out.println(this.name);
    }

    //方法内部的变量都叫做局部变量，只对方法内有效

    //this用来解决变量名字冲突的问题
    public void printHobby(String name) {
        System.out.println(this.name + "喜欢" + name);
    }
}
