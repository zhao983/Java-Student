package com.javademo.method;

public class MethodDemo1 {
    public static void main(String[] args) {
        System.out.println(Sum(4, 7));
        division(8,0);
    }
    //任意两数之和
    public static int Sum(int a,int b){
        int sum = a+b;
        return sum;
    }

    public static void division(int a,int b){
        if (b == 0){
            System.out.println("除数不能为0");
            return;
        }

        //return可以提前结束void型的方法
        System.out.println(a/b);
    }
}
