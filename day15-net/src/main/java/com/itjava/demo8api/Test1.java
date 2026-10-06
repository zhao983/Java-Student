package com.itjava.demo8api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //目标：掌握Java提供的获取时间的方法
        //JDK 8以前
        Date d = new Date();
        System.out.println(d);

        //格式化：SimpleDateFormat简单格式化日期                                       星期几 上午/下午
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String format = sdf.format(d);
        System.out.println(format);

        //JDK 8以后
        //获取此刻时间对象
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getDayOfMonth());

        LocalDateTime now2 = now.plusSeconds(60); //加60秒
        System.out.println(now2);

        //格式化：
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String s = dtf.format(now);
        System.out.println(s);
    }
}
