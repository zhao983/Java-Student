package com.javademo.variable;

public class variableDemo1 {
    public static void main(String[] args) {
        PrintVariable();
    }
    public static void PrintVariable(){
        //二进制必须以0B开头
        int a1=0B0101;
        System.out.println(a1);
        //八进制以0开头
        int a2= 0601;
        System.out.println(a2);
        //十六进制以0X开头
        int a3=0XF101;
        System.out.println(a3);
    }
}
