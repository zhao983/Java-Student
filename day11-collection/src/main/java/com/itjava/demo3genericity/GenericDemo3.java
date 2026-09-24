package com.itjava.demo3genericity;

public class GenericDemo3 {
    public static void main(String[] args) {
        //搞清楚泛型接口的作用
        //需求：项目对学生的数据进行增删改查
        StudentData studentData = new StudentData();
        studentData.add(new Student());
        studentData.delete(new Student());
        Student student = studentData.quer(1);
    }
}
