package com.itjava.innerclass2;

public class Outer {
    private static String name="外部类静态成员";
    private int age;
    public static class Inner {

        public void show(){
            System.out.println("内部类");
            //静态内部类的成员可以直接访问外部类的静态成员
            System.out.println(name);

            //静态内部类的成员不能直接访问外部类的实例成员
//            System.out.println(age);  //报错


        }
    }
}
