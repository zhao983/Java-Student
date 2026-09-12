package com.javademo.extends4constructor;

//理解子类构造器
public class Test {
    public static void main(String[] args) {
        B b = new B();
        B b1 = new B(2);

    }
}

class A {
    public A() {
        System.out.println("父类无参构造器");
    }

    public A(int a) {
        System.out.println("父类有参构造器");
    }
}


class B extends A {
    //子类的全部构造器都会先调用父类的构造器，再执行自己的构造器
    //因为默认情况下子类的构造器第一行都有一个super(),他会调用父类的无参构造器
    //如果父类没有无参构造器，需要自己手写一个super(参数)，去调用父类的有参构造器

    public B() {
        //super();
        System.out.println("子类无参构造器");
    }

    public B(int a) {
        super(2);//指令：调用父类的有参构造器,不写的话默认调用父类的无参
        //super();报错：一个构造器只能调用一次父类构造器，并且 super(...) 必须是构造器中的第一条语句。
        System.out.println("子类有参构造器");
    }
}