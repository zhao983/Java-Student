package com.javademo.extends5constructor;

public class Student extends People {
    private double score;

    public Student(String name, int age, double score) {
        //可以把子类继承自父类的这部分数据也进行初始化赋值
        super(name, age);
        this.score = score;
    }

    public Student() {
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
