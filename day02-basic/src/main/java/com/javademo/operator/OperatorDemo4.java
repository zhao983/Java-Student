package com.javademo.operator;

public class OperatorDemo4 {
    public static void main(String[] args) {
        printFt();

    }

    //&和|：会判断到结束
    // &&和||：判断左边为false（true）时，左边就不执行

    public static void printFt(){
        int a = 20;
        int b = 10;
        int c =5;
        System.out.println(a<b&&(b=(b-8))>c);//b-8不会执行
        System.out.println("b="+b);
        System.out.println(b>c);

        System.out.println(a<b&(b=(b-8))>c);//b-8会执行
        System.out.println("b="+b);
        System.out.println(b>c);



    }
}
