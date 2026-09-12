package com.javademo.polymorphsm1;
//认识多态
public class Test {
    public static void main(String[] args) {

        //多态有对象的多态

        Animal a1 = new Tortoise();
        Animal a2 = new Wolf();

        //多态有方法的多态
        a1.run();
        a2.run();
        //这是因为编译看左边，运行看右边

        //但多态没有变量的多态，因为多态只强调对象和行为
        System.out.println(a1.getName());//输出动物
        System.out.println(a2.getName());//输出动物

    }
}
