package com.itjava.abstract1;

public abstract class A {
    //抽象类中不一定有抽象方法，但有抽象方法一定是抽象类
    //抽象类也可以有正常的类中所具有的成员和方法
    private String name;
    private int age;
    public void printNormal(){
         System.out.println("抽象类中的普通方法");
    }

    //抽象方法没有方法体，只有方法声明
    public abstract void printAbstract();
}


/*

abstract class C{
    //但有抽象方法一定是抽象类
    public abstract void print(){
        System.out.println("报错");
    }
}
*/
