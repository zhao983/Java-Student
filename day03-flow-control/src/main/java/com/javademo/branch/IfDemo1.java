package com.javademo.branch;

import java.util.Scanner;

public class IfDemo1 {
    public static void main(String[] args) {
        test1();

        test2();

        test3();

    }

    public static void test1(){
        int age = 18;
        if (age >= 18)
            System.out.println("可以上网");
        System.out.println("洗洗睡吧");
    }

    public static void test2(){
        int age = 18;
        if(age>18)
            System.out.println("可以上网");
        else System.out.println("洗洗睡吧");
    }

    public static void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数:");
        int score = sc.nextInt();
        if (score>100){
            System.out.println("请重新输入分数！");
            test3();
        }else{
            if (score>=90&&score<=100){
                System.out.println('A');
            } else if (score>=80&&score<90) {
                System.out.println('B');
            } else {
                System.out.println('C');
            }
        }



    }
}
