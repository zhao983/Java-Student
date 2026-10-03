package com.itjava.demo5synchronized_methon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private double money;

    //在方法前面加synchronized
    //如果方法是实例方法：同步方法默认用this作为的锁对象。
    //如果方法是静态方法：同步方法默认用类名.class作为的锁对象。
    public synchronized void drawMoney(double money) {
        //拿到当前谁来取钱
        String name = Thread.currentThread().getName();
        //判断当前余额是否足够
        //建议共享资源为锁对象
        if (this.money >= money) {
            System.out.println(name + "取钱成功，取出了" + money + "元");
            this.money -= money;
            System.out.println("余额为:" + this.money + "元");
        } else {
            System.out.println(name+"取钱失败,余额不足");
        }
    }
}
