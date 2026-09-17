package com.itjava.innerclass2;

public class InnerClassDemo2 {
    //认识静态内部类
    public static void main(String[] args) {
        //创建对象：外部类名.内部类名 对象名 = new 外部类名.内部类名;
        Outer.Inner oi = new Outer.Inner();
        oi.show();

        //1.静态内部类的成员可以直接访问外部类的静态成员
        //2.静态内部类的成员不能直接访问外部类的实例成员
    }
}
