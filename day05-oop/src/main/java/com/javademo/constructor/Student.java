package com.javademo.constructor;

public class Student {
    String name;
    int age;

    //构造器：是一种特殊的方法，没有返回值，且必须与类名一致

    /*无参构造器
    类自带一个无参构造器，但如果自己定义了一个有参构造器，类的无参构造器就没有了，
    想再调用无参构造器必须手写一个无参构造器*/
    public Student(){
        System.out.println("无参构造器被调用了");

    }

    //有参数构造器
    public Student(int age){
        System.out.println("年龄为"+age);

    }

    //构造器可以重载
    public Student(String name){
        System.out.println("名字为："+name);

    }

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }



    public void printName(){
        System.out.println(name);
    }

    public void printAge(){
        System.out.println(age);
    }
}
