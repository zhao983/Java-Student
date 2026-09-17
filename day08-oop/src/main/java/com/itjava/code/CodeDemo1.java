package com.itjava.code;
//类中有五大成分：成员变量，构造器，方法，代码块，内部类
public class CodeDemo1 {
    public static String name;  //静态变量属于类  实例变量属于对象
    public static int[] count=new int[3];
    //认识静态代码块
    public static void main(String[] args) {
        System.out.println("main方法执行了");
    }

    //静态代码块：有static修饰，属于类，与类一起优先加载
    static {
        System.out.println("静态代码块优先加载");
        //基本作用，可以完成对类静态资源的初始化
        name="张三";
        //可以用来初始化数组，这样不用每一个方法中都初始化数组
        count[0]=1;
        count[1]=2;
        count[2]=3;

    }
}
