package com.javademo.type;

public class TypeDemo1 {
    public static void main(String[] args) {
        byte a = 2;
        printInt(a);
        printDouble(a);
        System.out.println("------------------------");

        int b = 20;
        //printByte(b);//
        byte b1 = (byte) b;
        printByte(b1);

        int c = 1200;
        byte c1 = (byte) c;
        printByte(c1);//超出byte的最大值127，出现数据溢出

        //double强制转换为int会导致小数部分消失
        System.out.println("------------------------");
        double d = 2.12;
        int d1 = (int) d;
        printInt(d1);
    }
    //自动类型转换，小的可以自动转换为大的：byte->short(char)->int->long->float->double
    public static void printInt(int a){
        System.out.println(a);
    }
    public static void printDouble(double a){
        System.out.println(a);
    }

    //强制类型转换
    public static void printByte(byte a){
        System.out.println(a);
    }


}
