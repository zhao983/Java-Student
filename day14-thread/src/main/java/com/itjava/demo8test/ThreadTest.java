package com.itjava.demo8test;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {
    public static void main(String[] args) {
        // 目标：完成多线程的综合小案例
        // 红包雨游戏，某企业有100名员工，员工的工号依次是1，2，3，4，..到100。
        // 现在公司举办了年会活动，活动中有一个红包雨环节，要求共计发出200个红包雨。
        // 其中小红包在[1 - 30] 元之间，总占比为80%，
        // 大红包[31-100]元，总占比为20%。
//        具体的功能点如下
//        1、系统模拟上述要求产生200个红包。
//        2、模拟100个员工抢红包雨，需要输出哪个员工抢到哪个红包的过程，活动结束时需要提示活动结束。

        //先得到这100个红包
        List<Double> redPacket = getRedPacket(); //在静态方法中调用到方法也应该是静态的，用static修饰

        //分析：100个员工实际就是100个线程,去创建员工抢红包的实现类对象
        for (int i = 1; i <= 100; i++) {
            new PeopleGetRedPacket(i,redPacket).start();
        }
    }

    //1.先准备200个红包,放到List集合中去返回
    public static List<Double> getRedPacket() {
        //准备一个List集合
        List<Double> redPacket = new ArrayList<>();
        // 其中小红包在[1 - 30] 元之间，总占比为80%，
        for (int i = 0; i < 160; i++) {
            // 存储时四舍五入
            double money = Math.round((1 + Math.random() * 30) * 100) / 100.0;
            redPacket.add(money);
        }

        // 大红包[31-100]元，总占比为20%。
        for (int i = 160; i < 200; i++) {
            double money = Math.round((31 + Math.random() * 70) * 100) / 100.0;
            redPacket.add(money);
        }

        return redPacket;
    }
}
