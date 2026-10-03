package com.itjava.demo6lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private double money;
    //创建一个锁对象
    private final Lock lock = new ReentrantLock();  //加final修饰防止锁被篡改  如lock=null

    public void drawMoney(double money) {
        //拿到当前谁来取钱
        String name = Thread.currentThread().getName();

        lock.lock(); //上锁

        try {
            //判断当前余额是否足够
            if (this.money >= money) {
                System.out.println(name + "取钱成功，取出了" + money + "元");
                this.money -= money;
                System.out.println("余额为:" + this.money + "元");
            } else {
                System.out.println("余额不足");
            }
        } finally {  //用finally保证锁最后一定会被解锁
            lock.unlock(); //解锁
        }
    }
}
