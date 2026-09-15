package com.itjava.interface5;

// 目标：理解接口的几点注意事项。
public class Test {
    public static void main(String[] args) {
        A4 a4 = new A4();
        a4.showFatherOrInter();
    }
}

// 1、接口与接口可以多继承：一个接口可以同时继承多个接口[重点]。
// 类与类：  单继承  一个类只能继承一个直接父类
// 类与接口：多实现，一个类可以同时实现多个接口。
// 接口与接口： 多继承，一个接口可以同时继承多个接口。
interface A {
    void show1();
}

interface B {
    void show2();
}

interface C extends A, B {
    void show3();
}

class CImpl implements C {


    @Override
    public void show3() {

    }

    @Override
    public void show1() {

    }

    @Override
    public void show2() {

    }
}

//2、一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承，也不支持多实现。
interface A1 {
    void show();
}

interface A2 {
    void show();

    default void print() {
        System.out.println("接口方法");
    }
//    String show()  //返回值不同，报错
}

//当A1，A2返回值相同时，可以直接继承，因为他们会被是为一个方法
interface A3 extends A1, A2 {
}

class B1 {
    public void print() {
        System.out.println("父类方法");
    }
}
//3、一个类继承了父类，又同时实现了接口，如果父类和接口中有同名的默认方法，实现类会优先用父类的。

class A4 extends B1 implements A2 {
    public void showFatherOrInter() {
        print();
    }
    //想要调用到接口的方法可以做一个中专转接父类的方法
/*
    //这样用go()方法调用父类方法，用print调用接口方法
    public void go(){
        print(); //父类方法
        super.print();  //父类方法
        //也有另一种方法，这样接口名.super.方法名，可以强行调用接口方法[了解]
        A2.super.print();

    }
*/

    @Override
    public void show() {

    }

}

//4、一个类实现了多个接口，如果多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可。
class C1 implements A1,A2{
//A1,A2中都有show()方法
    @Override
    public void show() {

    }
}
