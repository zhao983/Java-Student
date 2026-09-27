package com.itjava.demo1hashset;


import java.util.HashSet;
import java.util.Set;

public class SetDemo2 {
    //目标：掌握HashSet去重操作
    public static void main(String[] args) {
        Student s1 = new Student("张三", "男");
        Student s2 = new Student("张三", "男");
        Student s3 = new Student("李四", "女");
        Student s4 = new Student("李四", "女");

        Set<Student> studentSet = new HashSet<>();
        //加入的时候会自动根据哈希值算位置，也就是调用他们的hashCode方法，所以要重写该方法
        studentSet.add(s1);
        //当哈希值相等的时候，就会进行内容比较
        studentSet.add(s2);
        studentSet.add(s3);
        studentSet.add(s4);

        System.out.println(studentSet);
    }
}
