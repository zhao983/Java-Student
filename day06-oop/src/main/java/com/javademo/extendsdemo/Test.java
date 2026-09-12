package com.javademo.extendsdemo;

//认识继承
//好处：代码复用性，减少代码重复
public class Test {
    public static void main(String[] args) {

        Student stu = new Student();
        //子类能直接访问父类的共有方法
        stu.setName("张三");
        stu.setAge(18);
        stu.setScore(80);

        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getScore());


    }
}
