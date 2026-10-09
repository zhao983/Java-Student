package com.itjava.demo3annotation;

//@MyTest  //报错
public class AnnotationDemo2 {
    @MyTest
    private int a;
    public static void main(String[] args) {
        //目标:掌握元注解 (注解注解的注解)

    }

    @MyTest
    public void test(){

    }
}
