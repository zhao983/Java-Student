package com.javademo.capsulation;

public class Student {
    //封装思想，合理隐藏，合理暴露
    //目前已经习惯把对象里面的成员变量全部设置为私有（隐藏）
    //用private来修饰成员变量，之后设置一个共有的方法来赋值和访问
    private String name;
    private int age;

    public Student() {

    }

    //目前行业规范的赋值和访问分别为set和get
    //用public来设置一个共有的，可以访问的方法
    //优点是可以方便审查,并且已经成为行业习惯，不管用不用审查都建议这样做
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 200) {
            this.age = age;
        } else {
            System.out.println("输入年龄非法!");
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
