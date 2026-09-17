package com.itjava.code;

public class CodeDemo2 {
    private String[] direction=new String[4];
    //实例代码块属于对象，每次创建对象的时候都会执行一次
    {
        System.out.println("实例代码块执行了");
        //基本作用：初始化对象的实例资源
        direction[0]="W";
        direction[1]="E";
        direction[2]="N";
        direction[3]="S";
    }

    public static void main(String[] args) {
        //认识实例代码块（构造代码块）
        System.out.println("main方法执行了");
        new CodeDemo2();
    }
}
