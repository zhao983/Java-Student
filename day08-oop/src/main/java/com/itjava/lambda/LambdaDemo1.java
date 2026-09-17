package com.itjava.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        //目标：认识lambda表达式，搞清楚其基本作用
        //用来简化代码
        //格式
        /*(被重写方法的形参列表) -> {
         重写的方法体
         }*/
        Animal animal = new Animal() {
            @Override
            public void cry() {
                System.out.println("喵");
            }
        };
        animal.cry();
        /*
        //错误示范，lambda并不能简化全部的匿名内部类，只能简化函数式接口的匿名内部类
        Animal animal1 = () -> {
            System.out.println("喵");
        };
        */
        System.out.println("-------------");

        Swim swim =() -> {
            System.out.println("学生游泳");
        };
        swim.swimming();



    }
}


abstract class Animal{
    public abstract void cry();
}

//Java中函数式指的是只有一个抽象方法的接口
@FunctionalInterface //函数式接口的声明
interface Swim{
    void swimming();
}