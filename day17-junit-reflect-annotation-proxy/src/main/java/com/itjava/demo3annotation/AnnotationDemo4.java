package com.itjava.demo3annotation;

import java.lang.reflect.Method;

public class AnnotationDemo4 {


    //目标:搞清楚注解的应用场景,使用注解开发简易的Junit框架
    public static void main(String[] args) throws Exception {
        //invoke启动需要类的一个对象 不是类对象
        AnnotationDemo4 an4  = new AnnotationDemo4();

        //1.获取类对象  (获得的是类对象不是类的对象)
        Class c1 = AnnotationDemo4.class;
        //2.获取类的所有方法对象
        Method[] m1s= c1.getDeclaredMethods();
        //3.使用isAnnotationPresent判断这个方法上是否陈列了注解TestA
        for (Method m1 :m1s){
            if(m1.isAnnotationPresent(TestA.class)){
                //4.启动方法
                m1.invoke(an4);

            }
        }

    }

    @TestA
    public void test1(){
        System.out.println("测试方法一执行了");
    }

    public void test2(){
        System.out.println("测试方法二执行了");
    }


}
