package com.itjava.abstract3;

public class Test {
    //写一篇学校的作文
    //学生和老师的开头和结尾写的一样，中间不同
    //《我的学校》
    //让我来给你们介绍一下我的学校
    //这就是我的学校
    //这样就可以把重复的抽出来写成模板放在抽象类中
    public static void main(String[] args) {
        Student s = new Student();
        s.write(); //子类找方法的时候先去子类中找，子类找不到再去父类找
        //所以这里的write子类找不到，就去父类，等父类执行到writeSchool()时，子类中找到了，就执行子类的
    }
}
