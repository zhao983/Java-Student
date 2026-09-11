package com.javademo.stativfield;

//认识static（静态）
public class Student {
    //静态变量：static修饰表示这个变量只属于这个类，会被类的全部对象共享
    static String name;
    //实例变量：无static修饰，属于每个对象
    int age;
    static int number;


    public Student() {
        //因为每次都会调用构造器
        number++;
    }

    public Student(int age) {
        this.age = age;
        number++;//访问自己类中的变量可以不写类名
    }
}
