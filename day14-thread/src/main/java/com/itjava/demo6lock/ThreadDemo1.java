package com.itjava.demo6lock;

public class ThreadDemo1 {
    public static void main(String[] args) {
        // 目标：掌握线程同步的第三种方法： Lock锁
        // 1、设计一个账户类：用于创建小明和小红的共同账户对象，存入1万。
        Account acc = new Account("1", 10000);
        //设置线程类，创建小明小红两个线程，模拟在同一个账号取1万元
        new DrawThread("小明", acc).start();
        new DrawThread("小红", acc).start();

    }


}
