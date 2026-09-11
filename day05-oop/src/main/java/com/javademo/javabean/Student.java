package com.javademo.javabean;
//实体类：内部的成员变量全部私有，且为他们提供get，set方法，并且必须有一个无参构造器，无参可选
public class Student {
    private String name;
    private int age;

    //构造器
    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
