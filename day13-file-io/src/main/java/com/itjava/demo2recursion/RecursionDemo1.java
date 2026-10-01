package com.itjava.demo2recursion;

public class RecursionDemo1 {
    public static void main(String[] args) {
        //认识递归
        //计算n的阶乘
        System.out.println(f(5));

        //求1到n的和
        System.out.println(sum(10));

        //猴子吃桃问题
        System.out.println(test(1));
    }

    //计算n的阶乘
    private static int f(int n) {
        if (n == 1) return 1;
        return f(n - 1) * n;
    }

    //求1到n的和
    private static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    //猴子吃桃问题
    private static int test(int n) {
        if (n == 10) {
            return 1;
        }

        return (test(n + 1) + 1) * 2;
    }
}
