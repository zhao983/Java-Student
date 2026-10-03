package com.itjava.demo2threadapi;

public class ThreadApiDemo1 {
    public static void main(String[] args) {
        //目标：掌握线程的常用方法
        Thread t1 = new MyThread("子线程1");
//        t1.setName("子线程1");   //线程设置名字要在线程开始前
        t1.start();
        System.out.println(t1.getName());  //得到线程名字

        Thread t2 =new Thread();
        t2.start();

        //哪个线程调用这个方法。就拿到哪个线程
        Thread m = Thread.currentThread();
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);  //sleep方法，让线程暂停一段时间后接着执行
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i =0;i<5;i++){
            System.out.println("主线程"+i);
            if (i==1){
                try {
                    t2.join();  //join方法，让线程插队，必须等这个执行完毕后才会接着往下执行
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

//1.定义一个子类继承Thread，成为一个线程类
class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    //2.重写run方法，在里面写下子线程要做的事情
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程运行" + i);
        }
    }
}
