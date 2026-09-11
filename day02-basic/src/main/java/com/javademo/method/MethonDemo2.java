package com.javademo.method;

public class MethonDemo2 {
    public static void main(String[] args) {
        print(1);
    }
    //方法的重载
    public static void print(int a){
        System.out.println(a);
    }

    public static void print(double a){
        System.out.println(a);
    }

    public static void print(int a,double b){
        System.out.println(a);
    }

    public static void print(double a,int b){
        System.out.println(a);
    }
    //报错，不关心形参名称，只看类型不同，个数不同，顺序不同
    /*public static void print(double b,int a){
        System.out.println(a);
    }*/
}
