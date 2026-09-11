package com.javademo.thisdemo;

public class Test {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.name = "张三";

        st1.printThis();//这里会打印st1的地址,第二行打印st1的name


        Student st2 = new Student();
        st2.name="李四";
        //在这个方法中加this能明确要访问的是st2这个变量，然后找到这个变量的name，与传进去的name参数区分开
        st2.printHobby("唱歌");//不加this会输出唱歌喜欢唱歌




    }
}
