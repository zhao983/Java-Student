package com.javademo.staticmethon;

public class Student {
    private int age;



    //静态方法，有static修饰，属于类所有
    //静态方法可以用来做工具类(Util)
    public static void printHelloWorld(){
        System.out.println("Hello WOrld!");
    }

    //实例方法，没有被static修饰
    public void printAge(){
        System.out.println(age);
    }

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
