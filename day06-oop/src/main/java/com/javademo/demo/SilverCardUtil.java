package com.javademo.demo;
//工具类，用来判断余额是否充足
public class SilverCardUtil {
    private SilverCardUtil() {
    }

    /*public static void balanceIsEnough(double balance, double money) {
        if (balance < money * 0.9) {
            System.out.println("你的余额不足!");
            return;//这个return之后执行这里面的方法，不会结束调用类里面的方法
        }
    }*/

    public static boolean balanceIsEnough(double balance, double money) {
        if (balance < money * 0.9) {
            System.out.println("你的余额不足!");
            return false;//这个return之后执行这里面的方法，不会结束调用类里面的方法
        }

        return true;
    }
}
