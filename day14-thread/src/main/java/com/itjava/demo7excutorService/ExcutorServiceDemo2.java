package com.itjava.demo7excutorService;

import java.util.concurrent.*;

public class ExcutorServiceDemo2 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
                //创建一个线程队列                       创建一个线程工厂                     线程的拒绝策略
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //使用线程池来处理Runnable任务
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));

        try {
            System.out.println(f1.get());  //用get方法得到结果
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(f3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    //2.重写call方法，定义线程执行体
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + n + "的和为:" + sum;
    }
}
