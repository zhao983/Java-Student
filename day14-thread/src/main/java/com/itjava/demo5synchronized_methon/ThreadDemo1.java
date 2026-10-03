package com.itjava.demo5synchronized_methon;

public class ThreadDemo1 {
    public static void main(String[] args) {
        // 目标：线程同步代码方式二演示：同步方法
        // 1、设计一个账户类：用于创建小明和小红的共同账户对象，存入1万。
        Account acc = new Account("1", 10000);
        //设置线程类，创建小明小红两个线程，模拟在同一个账号取1万元
        new DrawThread("小明", acc).start();
        new DrawThread("小红", acc).start();

        Account acc2 = new Account("2", 50000);
        new DrawThread("小白", acc2).start();
        new DrawThread("小黑", acc2).start();

    }


}
