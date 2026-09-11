package com.javademo.loop;

public class ForDemo1 {
    public static void main(String[] args) {
        forTest1();

    }

    public static void forTest1(){
        for(int i=0;i<3;i++){
            System.out.println("Hello World!");
            for(int j=0;j<3;j++){
                System.out.println("你好世界！");

            }
        }
    }
}
