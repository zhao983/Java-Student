package com.itjava.demo4test;

import java.util.Arrays;

public class ParamDemo1 {
    //认识可变参数
    public static void main(String[] args) {
        sum(); //可以不传参
        sum(10);//可以只穿一个
        sum(10,11,12);//可以传多个

        sum2(1);
        sum2(1,2,3);

    }
    private static void sum(int...num){  //本质是以数组实现的
        System.out.println(num.length);
        System.out.println(Arrays.toString(num));
        System.out.println("-------------------");
    }

    //可变参数只能有一个，并且必须放到最后面
    private static void sum2 (int age,int...num){

    }

}
