package com.javademo.operator;

public class OperatorDemo2 {
    public static void main(String[] args) {
        device();
        System.out.println("-----------------");
        printYn();
    }

    //赋值运算符 +=，-=，/=，*=，
    public static void device(){
        int a = 5;
        a += 5;
        System.out.println(a);

        //a += 5 -> a=（a的类型）a+5；会强制转换为a的类型
        a += 2.3;
        System.out.println(a);
    }

    //关系运算符
    public static void printYn(){
        int a = 20;
        int b = 4;
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a!=b);//不等于
        System.out.println(a==b);//等于
    }
}
