package com.javademo.operator;

import java.util.Scanner;

public class OperatorDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        max(a,b);

    }

    //三元运算符
    //条件表达式？值1：值2  判断条件表达式的值，值为真返回值1，为假返回值2
    public static void max(int a,int b){
        int c = a > b ? a : b;
        System.out.println(c);
    }
}
