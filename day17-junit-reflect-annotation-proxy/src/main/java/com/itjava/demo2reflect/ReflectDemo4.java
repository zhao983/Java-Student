package com.itjava.demo2reflect;

public class ReflectDemo4 {
    //目标:搞清楚反射的作用,做通用框架技术
    public static void main(String[] args) throws Exception {
        Student student = new Student("张三","男");
        SaveObjectFrameWork.saveObject(student);

        Teacher teacher = new Teacher("李四","看书");
        SaveObjectFrameWork.saveObject(teacher);
    }


}
