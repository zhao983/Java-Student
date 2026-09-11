package com.javademo.staticmethon;

public class Test {
    public static void main(String[] args) {

        //可以直接用类名去访问
        Student.printHelloWorld();

        System.out.println("------------------");

        Student stu1 = new Student();
        //也可以用对象名去访问，但不推荐
        stu1.printHelloWorld();

        stu1.setAge(18);
        stu1.printAge();
        //Student.printAge(); 用类名.实例方法会报错

        // 规范：如果这个方法只是为了做一个功能且不需要直接访问对象的数据，这个方法直接定义成静态方法
//       如果这个方法是对​​象的行为，需要访问对象的数据，这个方法必须定义成实例方法


        //同一个类中的静态方法可以不写类名
//      Test.printHelloWorld1();
        printHelloWorld1();

        //printHelloWorld2();//会报错



    }

    public static void printHelloWorld1(){
        System.out.println("Hello WOrld!");
    }

    public void printHelloWorld2(){
        System.out.println("Hello WOrld!");
    }
}
