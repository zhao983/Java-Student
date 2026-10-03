package com.itjava.demo7excutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorDemo3 {
    public static void main(String[] args) {
        //目标：掌握通过Executors工具类来创建新的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        //使用线程池来处理Runnable任务，看看会不会复用线程
        Runnable target = new MyThread2();
        pool.execute(target);  //execute执行Runnable任务
        pool.execute(target);
        pool.execute(target); //线程占用完
        pool.execute(target); //复用线程
        pool.execute(target); //复用线程
    }
}

class MyThread2 extends Thread {
    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    //2.重写run方法，在里面写下子线程要做的事情
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"子线程运行" + i);
        }
    }
}

/*
是一个线程池的工具类，提供了很多静态方法用于返回不同特点的线程池对象。

方法名称	说明
public static ExecutorService newFixedThreadPool(int nThreads)	创建固定线程数量的线程池，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程替代它。
public static ExecutorService newSingleThreadExecutor()	创建只有一个线程的线程池对象，如果该线程出现异常而结束，那么线程池会补充一个新线程。
public static ExecutorService newCachedThreadPool()	线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了60s则会被回收掉。
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)	创建一个线程池，可以实现在给定的延迟后运行任务，或者定期执行任务。
*/
/*

线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
说明：Executors 返回的线程池对象的弊端如下：
        1）FixedThreadPool 和 SingleThreadPool：
允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM(内存溢出异常)。
        2）CachedThreadPool 和 ScheduledThreadPool：
允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
*/


