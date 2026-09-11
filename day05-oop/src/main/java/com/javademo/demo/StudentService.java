package com.javademo.demo;

import java.util.Scanner;

public class StudentService {

    //先创建一个类的对象
    private Student[] stu;

    public StudentService() {
    }

    //创建含参构造器
    public StudentService(Student[] stu) {
        this.stu = stu;
    }

    public void printStudent() {
        for (int i = 0; i < stu.length; i++) {
            StudentUtil.printStudentUtil(stu[i]);
            //调用工具类要直接写类名
        }

    }

    public void searchStudent() {
        System.out.println("请输入要查找到学生id：");
        int id;
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        for (int i = 0; i < stu.length; i++) {
            if (stu[i].getId() == id) {
                StudentUtil.printStudentUtil(stu[i]);
                //调用工具类要直接写类名
                return;

            }
        }
        System.out.println("没有找到符合要求的学生");
    }
}
