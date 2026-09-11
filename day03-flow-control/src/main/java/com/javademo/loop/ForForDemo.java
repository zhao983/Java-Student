package com.javademo.loop;

public class ForForDemo {
    public static void main(String[] args) {
        test();

    }

    //九九乘法表
    public static void test(){
        int a = 1;
        int b = 9;
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(j+"*"+i+"="+j*i+" ");//print不换行
            }
            System.out.println();//println换行
        }
    }
}
