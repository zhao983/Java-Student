package com.itjava.demo1hashset;

import java.util.Objects;

public class Student {

    private String name;
    private String sex;

    //HashSet去重操作需要让内容相同的类的哈希值一样，所有需要重新hashCode方法
    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }

    //但不同的内容有时候哈希值也一样，所有还要再判断内容是否相等
    //只要两个内容一样结果一定是true
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(sex, student.sex);
    }



    public Student() {
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}' + "\n";
    }
}
