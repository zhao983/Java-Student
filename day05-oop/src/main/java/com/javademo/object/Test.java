package com.javademo.object;

public class Test {

    public static void main(String[] args) {
        //对象是用类new出来的
        Star s1 = new Star();
        //这两个类在同一个包里，所以可以直接使用，不需要 import。
        s1.name = "李二";
        s1.age = 18;
        s1.height = 178.8;
        s1.weight = 68.8;
        s1.score = 95;

        Star s2 = new Star();
        //这两个类在同一个包里，所以可以直接使用，不需要 import。
        s2.name = "张三";
        s2.age = 18;
        s2.height = 178.8;
        s2.weight = 68.8;
        s2.score = 85;

        testSum(s1.score, s2.score);


    }

    //算总成绩和平均成绩
    public static void testSum(double score1, double score2) {
        double sum = 0;
        sum = score1 + score2;
        System.out.println("总成绩为：" + sum);
        double averagr = sum / 2;
        System.out.println("平均成绩为：" + averagr);


    }

}
