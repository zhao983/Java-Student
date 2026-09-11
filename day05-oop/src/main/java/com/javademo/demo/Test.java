package com.javademo.demo;

public class Test {
    public static void main(String[] args) { //要运行的地方一定不要忘写main方法
        //做一个学生显示的页面，并且可以根据id查找学生信息

        //第一步要有一个学生类:名字，年龄，性别
        Student[] stu = new Student[5];
        stu[0] = new Student(1, "张三", 18, "男");
        stu[1] = new Student(2, "李四", 18, "男");
        stu[2] = new Student(3, "王五", 18, "男");
        stu[3] = new Student(4, "赵六", 18, "男");
        stu[4] = new Student(5, "唐七", 18, "男");

        //将这些信息存到一个服务类中处理,实体类中只负责数据的存和取
        StudentService stuService =new StudentService(stu);
        stuService.printStudent();
        stuService.searchStudent();


    }

}
