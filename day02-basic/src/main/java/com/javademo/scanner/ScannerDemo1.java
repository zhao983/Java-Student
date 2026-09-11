package com.javademo.scanner;

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        printUser();

    }

    public static void printUser(){
        //创建对象(抄写这一行代码，得到一个Scanner扫描器对象)
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名");
        String a = sc.next();
        //next()作用：让程序在这里暂停，直到用户输入了一串字符串，按下回车，并赋值给变量a后，让程序接着往下走
        System.out.println("您叫:"+a);
        System.out.println("请输入年龄");
        int b = sc.nextInt();
        //nextInt()作用：让程序在这里暂停，直到用户输入了一个整数，按下回车，并赋值给变量b后，让程序接着往下走
        System.out.println("年龄为:"+b);

    }
}
