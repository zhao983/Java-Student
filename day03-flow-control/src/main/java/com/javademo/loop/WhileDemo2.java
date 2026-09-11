package com.javademo.loop;

public class WhileDemo2 {
    public static void main(String[] args) {
        test1();

        test2();

        test3();

    }
    public static void test1(){
        //不知道要循环多少次推荐用while
        //如银行利润是1.7%，多少年后本金翻倍？
        int money = 10000;
        int year = 0;
        while (money <= 20000){
            money *= 1.017;
            year++;

        }
        System.out.println("需要"+year+"年");
    }

    //一张纸厚度为0.1mm，折叠多少次能达到珠穆朗玛峰的高度（高8848.86m=8848860mm）
    public static void test2(){
        double pear = 0.1;
        double peak = 8848860;
        int times = 0;
        while (pear <= peak){
            pear *= 2;
            times++;
        }
        System.out.println("折叠次数："+times);
    }

    //do...while至少执行一次，先执行再判断
    public static void test3(){
        int i = 0;
        do{
            System.out.println("Hello World!");
        }while (false);
    }
}
