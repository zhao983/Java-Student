package com.javademo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok技术可以实现为类自动添加get，set方法，无参和有参构造器
@Data                 //@Data可以自动生成get，set方法，无参构造器，toString方法等
@NoArgsConstructor
@AllArgsConstructor   //@AllArgsConstructor可以提供所有参数的构造器(但设置了有参无参就没了，所以要在上面加一个@NoArgsConstructor)
public class Card {
    //Card父类中一个包含金卡，银卡中都会有的信息，比如卡的主人姓名，电话号，余额
    private String name;
    private String phoneNumber;
    private double money;

    //金卡银卡都会有存钱和消费两种行为

    //存钱
    public void saveMoney(double money) {
        this.money += money;
    }

    //消费
    public void consumeMoney(double money) {
        this.money -= money;
    }


}
