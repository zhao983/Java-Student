package com.javademo.extendsfeature;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        //a.equals(); 这个equals就是Object的方法

        B b = new B();
        b.printTest();
        b.cry();

    }
}

//java中一个子类只能继承一个父类
//所有的类都有一个祖宗类Object
class A {
    String name = "父类中的变量";

    public void cry() {
        System.out.println("动物的叫声");
    }

}

//在java访问成员(变量，方法)的特点是就近原则,先找子类，再找父类，都没有就报错
class B extends A {
    String name = "子类中的变量";

    public void printTest() {
        String name = "方法中的变量";

        System.out.println(name);
        System.out.println(this.name);//访问当前子类中的变量可以用this
        System.out.println(super.name);//super关键字可以用来访问父类中的方法/变量
    }

    //方法重写：当父类的方法无法满足子类要求时，子类可以对父类的方法进行重写
    //重写要求方法名，形参列表都相同
    //要加一个@Override 表示这个方法是被重写的
    @Override
    public void cry() {   //并且要求子类中重写的方法要大于等于父类中的访问权限（public>proctected>缺/省(无private，因为私有方法不能被重写）)
        System.out.println("🐱喵喵喵");
    }
    //重写的返回值必须与父类中的一样或者范围更小
    //私有方法，静态方法不能被重写不能被重写
}

//但支持多层继承
class C extends B {

}
