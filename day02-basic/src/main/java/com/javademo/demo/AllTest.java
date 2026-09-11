package com.javademo.demo;

import java.util.Scanner;

public class AllTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入身高");
        double height = sc.nextDouble();

        System.out.println("请输入体重");
        double weight = sc.nextDouble();

        System.out.println("请输入年龄");
        int age = sc.nextInt();

        System.out.println("请输入性别");
        String sex = sc.next();

        System.out.println("BMI为"+calcBmi(weight,height));

    }
    public static double calcBmi(double weight,double height){
        return weight/(height*height);
    }

}
