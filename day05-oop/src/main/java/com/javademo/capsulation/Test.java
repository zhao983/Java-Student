package com.javademo.capsulation;

public class Test {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.setName("张三");
        st1.setAge(18);//这里会打印st1的地址,第二行打印st1的name
        System.out.println(st1.getName());
        System.out.println(st1.getAge());

    }
}
