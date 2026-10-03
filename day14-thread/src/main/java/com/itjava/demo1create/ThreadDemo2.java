package com.itjava.demo1create;

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 目标：掌握多线程的创建方式二：实现Runnable接口来创建。
        // 3、创建线程任务类的对象代表一个线程任务。
        Runnable r = new MyRunnable();
        //4.把线程任务交给一个线程对象
        Thread t1 = new Thread(r);
        //5.启动线程
        t1.start();

        //使用匿名内部类简化写法
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程2运行" + i);
                }
            }
        };
        Thread t2 =new Thread(r2);
        t2.start();

        //再简化
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程3运行" + i);
                }
            }
        });
        t3.start();

        //再简化
        Thread t4 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程4运行" + i);
            }
        });
        t4.start();

        for (int i = 0;i<10;i++){
            System.out.println("主线程运行"+i);
        }
    }
}

//1.定义一个子类实现Runnable接口
class MyRunnable implements Runnable {

    //2.重写run方法，在里面写下子线程要做的事情
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程1运行" + i);
        }
    }
}
