package com.itjava.demo4synchronized_code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private double money;

    public void drawMoney(double money) {
        //拿到当前谁来取钱
        String name = Thread.currentThread().getName();
        //判断当前余额是否足够
        //建议共享资源为锁对象
        synchronized (this) {  //实例方法用this
//        synchronized (Account.class) {  //静态方法用类名.class
            if (this.money >= money) {
                System.out.println(name + "取钱成功，取出了" + money + "元");
                this.money -= money;
                System.out.println("余额为:" + this.money + "元");
            } else {
                System.out.println(name+"取钱失败,余额不足");
            }
        }
    }
}
