package com.javademo.branch;

public class IfDemo2 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        boolean red = true;
        boolean yellow = false;
        boolean green = false;

        if(red){
            System.out.println("红灯停");
        } else if (yellow) {
            System.out.println("黄灯减速");
        } else if (green)
            System.out.println("绿灯行");
    }

}
