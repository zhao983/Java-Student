package com.javademo.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //创建一个支付小程序
        /*某加油站为了吸引更多的车主，推出了如下活动，车主可以办理金卡和银卡。
        卡片信息包括：、车主姓名、电话号码、卡片余额。
        金卡办理时存入金额必须>=5000元，银卡办理时预存金额必须>=2000元，金卡支付时享受8折优惠，银卡支付时享受9折优惠，金卡消费满200元可以提供打印免费洗车票的服务。*/

        //思路：先创建一个Card父类，为之后的金卡，银卡做铺垫

        //创建一个金卡对象
        GoldCard goldCard = new GoldCard("张三", "123456", 6000);

        //创建一个银卡对象
        SilverCard silverCard = new SilverCard("李四", "234567", 3000);

        //测试消费
        pay(goldCard);    //金卡
        pay(silverCard);  //银卡


    }

    //在这里写一个方法来负责支付
    //用父类来定义对象，这样金卡银卡就都能访问
    public static void pay(Card card) {
        System.out.println("请刷卡");
        System.out.println("请输入消费金额:");
        Scanner sc = new Scanner(System.in);
        //成员变量会被 Java 自动赋默认值；局部变量不会。这里的 money 是在方法中定义的，是局部变量。
        double money = 0;
        money = sc.nextDouble();
        card.consumeMoney(money);
    }


}
