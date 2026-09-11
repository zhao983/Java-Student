package com.javademo.type;

public class TypeDemo2 {
    public static void main(String[] args) {
        System.out.println(sum((byte)1,2,3,4));

        System.out.println(sum((byte)1,(short)2,'a'));

        System.out.println(sum((byte)1,(byte)2));

    }

    //表达式中返回值会用最大的那一个
    /*public static void sum(byte a,int b,float c,double d){
        return a+b+c+d;
    }*/
    public static double sum(byte a,int b,float c,double d){
        return a+b+c+d;
    }

    //byte,short,char会自动转换成int运算,选char/short/byte会报错
    public static int sum(byte a,short b,char c){
        return a+b+c;
    }

    //但也可以强制转换
    public static byte sum(byte a,byte b){
        return (byte)(a+b);
    }

}
