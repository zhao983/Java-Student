package com.javademo.demo;

public class StudentUtil {


    private StudentUtil() {
    }

    public static void printStudentUtil(Student stu){
        System.out.println(stu.getId() +"\t" +stu.getName() +"\t"+ stu.getAge()+"\t" + stu.getSex());
    }
}
