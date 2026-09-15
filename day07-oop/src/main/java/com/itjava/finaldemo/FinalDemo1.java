package com.itjava.finaldemo;

public class FinalDemo1 {
    //认识final关键字
    //final一般用来修饰静态成员变量,这个值一般作为系统配置信息
    public static final String SCHOOL_NAME = "大学";
    //行业习惯把这种变量全用大写字母，两个字母间用下划线隔开
    //final修饰的变量只能被赋值一次，所以也被叫做系统常量,赋值第二次会报错
    //SCHOOL_NAME = "高中";  //报错
    /*
    变量有哪些呢？
        a、成员变量：
            静态成员变量
            实例成员变量
        b、局部变量
    */

    //final修饰实例变量没有意义,因为静态变量属于类，实例变量属于对象，对象不能再次赋值给final修饰的变量
    final String name="初中"; //不报错,但无意义

    public static void main(String[] args) {
        //    final修饰变量的注意
//    final修饰基本类型的变量，变量存储的数据不能被改变。
        final int num=5;
        //num = 6;  //报错
//    final修饰引用类型的变量，变量存储的地址不能被改变，但地址所指向对象的内容是可以被改变的。
        final int[] arr = {10,3,5};
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("--------------");
        arr[1]=5;
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }





}

//final修饰类后，类不能被继承
final class A {
    //final修饰方法时，方法不能被重写
    public final void print() {
        System.out.println("final修饰方法");
    }
}

//class B extends A{}  //报错
class B {
    /*
    @Override  //重写报错
    public final void print(){
        System.out.println("final修饰方法");
    }
    */
}