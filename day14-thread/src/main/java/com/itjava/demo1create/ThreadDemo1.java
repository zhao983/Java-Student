package com.itjava.demo1create;

public class ThreadDemo1 {
    public static void main(String[] args) {
        //目标：认识多线程，掌握多线程的创建方法之一，继承Thread类来实现
        //3.创建一个线程类的对象，来代表线程
        Thread t1 = new MyThread();
        //4.调用start方法启动子线程  只有调用start才是一个新线程
        t1.start();   //不能直接调用run方法，否则会被当成普通方法执行，还是单线程


        for (int i = 0;i<10;i++){
            System.out.println("主线程运行"+i);
        }
    }
}

//1.定义一个子类继承Thread，成为一个线程类
class MyThread extends Thread {

    //2.重写run方法，在里面写下子线程要做的事情
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程运行" + i);
        }
    }
}