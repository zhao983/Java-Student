package com.itjava.demo2reflect;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：掌握反射的第一步操作，获得类本身
        //方式一：类.class
        Class c1 = Student.class;
        System.out.println(c1);

        //方式二：获得类本身
        Class c2 = Class.forName("com.itjava.demo2reflect.Student");
        System.out.println(c1 == c2);

        //方式三：获得类本身
        Student s = new Student();
        Class c3 = s.getClass();
        System.out.println(c3 == c2);
    }
}
