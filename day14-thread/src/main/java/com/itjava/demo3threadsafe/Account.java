package com.itjava.demo3threadsafe;

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
        if (this.money >= money) {
            System.out.println(name + "取钱成功，取出了" + money + "元");
            this.money -= money;
            System.out.println("余额为:" + this.money + "元");
        } else {
            System.out.println("余额不足");
        }
    }
}
