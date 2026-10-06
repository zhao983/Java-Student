package com.itjava.demo7excutorService;

import java.util.concurrent.*;

/*线程池作用
降低资源消耗：通过重复利用已创建的线程，减少线程创建和销毁的开销。
提高响应速度：任务可以立即执行，无需等待线程创建。
提高线程的可管理性：统一管理线程，便于监控和调优。
避免内存溢出：通过限制线程数量，防止系统资源耗尽。
支持并发编程：在并发环境中，线程池可以有效管理多个线程的执行。*/
public class ExcutorServiceDemo1 {
    public static void main(String[] args) {
        //目标：创建线程池对象来使用
        //1.使用线程池实现类                                   //  声明标准线程    最大线程     多余的线程空闲下来后的存活时间  存活时间的单位
        ExecutorService pool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,
                //创建一个线程队列                       创建一个线程工厂                     线程的拒绝策略
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //使用线程池来处理Runnable任务，看看会不会复用线程
        Runnable target = new MyThread();
        pool.execute(target);  //execute执行Runnable任务
        pool.execute(target);
        pool.execute(target); //线程占用完
        pool.execute(target); //复用线程
        pool.execute(target); //复用线程
        pool.execute(target);
        //什么时候开始创建临时线程？
        //
        //◆ 新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建临时线程。
        pool.execute(target); // 创建新线程
        pool.execute(target); // 创建新线程
        //什么时候会拒绝新任务？
        //
        //◆ 核心线程和临时线程都在忙，任务队列也满了，新的任务过来的时候才会开始拒绝任务。
        pool.execute(target); // 拒绝任务

        //3.关闭线程池 一般不关闭
//        pool.shutdown(); //等所有线程执行完毕后关闭
//        pool.shutdownNow(); //立刻关闭线程池，不管任务是否执行完毕

    }
}

/*任务拒绝策略

策略	说明
ThreadPoolExecutor.AbortPolicy()	丢弃任务并抛出RejectedExecutionException异常。是默认的策略
ThreadPoolExecutor.DiscardPolicy()	丢弃任务，但是不抛出异常，这是不推荐的做法
ThreadPoolExecutor.DiscardOldestPolicy()	抛弃队列中等待最久的任务 然后把当前任务加入队列中
ThreadPoolExecutor.CallerRunsPolicy()	由主线程负责调用任务的run()方法从而绕过线程池直接执行*/

//定义一个子类继承Thread，成为一个线程类
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
            System.out.println(Thread.currentThread().getName()+"子线程运行" + i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


