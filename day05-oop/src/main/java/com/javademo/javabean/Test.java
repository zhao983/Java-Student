package com.javademo.javabean;

public class Test {
    public static void main(String[] args) {
        //定义实体类
        Student st1 = new Student();
        st1.setName("张三");
        st1.setAge(18);

        //定义业务/操作类
        StudentService st1_service = new StudentService(st1);
        st1_service.printName();
        st1_service.printAge();




    }
}
