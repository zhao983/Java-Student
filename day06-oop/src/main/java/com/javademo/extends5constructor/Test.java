package com.javademo.extends5constructor;

//子类构造器的应用场景
public class Test {
    public static void main(String[] args) {
        //当前子类中只有score
        Student stu = new Student("张三", 18, 85);

        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getScore());

    }
}
