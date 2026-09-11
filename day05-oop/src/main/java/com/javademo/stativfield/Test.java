package com.javademo.stativfield;

public class Test {
    public static void main(String[] args) {

        //静态变量推荐用类名去访问
        Student.name = "张三";
        System.out.println(Student.name);

        //强行用对象名去访问也可以，但不推荐
        Student stu1 = new Student();
        stu1.name = "李四";
        stu1.age = 18;
        //System.out.println(Student.age);  报错
        System.out.println(stu1.name);

        Student stu2 = new Student();
        stu2.name = "王五";
        System.out.println(Student.name);

        //并且最后静态变量的值为最后一个赋予他的值
        System.out.println(stu1.name);

        Student stu3 = new Student(18);

        //静态变量可以用于统计创建了多少对象
        System.out.println(Student.number);


    }
}
