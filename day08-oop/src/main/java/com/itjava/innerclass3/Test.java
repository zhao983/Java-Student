package com.itjava.innerclass3;
//认识匿名内部类
//是一种特殊的局部内部类；
//所谓匿名：指的是程序员不需要为这个类声明名字，默认有个隐藏的名字。 外部类名$编号
public class Test {
    public static void main(String[] args) {

//        特点： 匿名内部类本质就是一个子类，并会立即创建出一个子类对象。
//        作用： 用于更方便的创建出一个子类对象。
        Animal animal = new Animal() {
            @Override
            public void cry() {
                System.out.println("喵~~");
            }
        }; //结尾的";"一定不要忘了
        animal.cry();

    }
}
/*

class Cat extends Animal{
    @Override
    public void cry() {

    }
}
*/
