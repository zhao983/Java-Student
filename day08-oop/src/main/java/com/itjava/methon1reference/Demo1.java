package com.itjava.methon1reference;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        //目标：静态方法引用
        Student[] stu=new Student[4];
        stu[0]=new Student("张三",18);
        stu[1]=new Student("李四",25);
        stu[2]=new Student("王五",16);
        stu[3]=new Student("赵六",34);

//      Arrays.sort(stu, (o1, o2)-> o1.getAge()-o2.getAge());
        //还可以简化
        //如果Lambda表达式只是调用一个静态方法，并且"->"前后参数一致，那么就可以用静态方法引用
        //格式为
        //类名::静态方法  (静态方法属于类)
        Arrays.sort(stu, Student :: compareByAge1);

        //还可以用实例方法简化
        //格式为
        //对象名::方法 (实例方法属于对象)
        Student s = new Student();
        Arrays.sort(stu,s::compareByAge2);

        for (int i=0;i<stu.length;i++){
            System.out.println(stu[i]);
        }

    }
}
