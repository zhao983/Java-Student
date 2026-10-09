package com.itjava.demo1;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
        // 1、随机6个不重复红球号码 1-35 1个蓝球1-15，升序输出，蓝球放最后面。

        Set<Integer> reds = new TreeSet<>();
        while (reds.size() < 6) {
            reds.add((int) (Math.random() * 35 + 1));
        }
        System.out.println("红球号码:"+reds);
        int blue = (int)(Math.random()*15+1);
        System.out.println("篮球号码:"+blue);

        // 2、定义一个集合存储中奖的号码，再判断中了几个红球，中了几个篮球号码。
        Set<Integer> luckreds = new TreeSet<>();
        Collections.addAll(luckreds,10,12,30,16,7,17);
        int luckblue = 12;

        int count=0;
        for(Integer red :reds){
            if (luckreds.contains(red)){
                count++;
            }
        }
        System.out.println("红球中了:"+count+"个");
        System.out.println("蓝球中了:"+((blue==luckblue)?"1个":"0个"));
    }
}
