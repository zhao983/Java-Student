package com.itjava.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        // 使用面向对象编程：创建对象代表一个一个的囚犯（第一次的位置和它的随机编号）

        //创建一个1到200的集合然后打乱
        List<Integer> random = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            random.add(i);
        }
        Collections.shuffle(random);

        //创建集合用来存储100个囚犯
        List<People> ps = new ArrayList<>();
        //把位置和随机id给100个囚犯
        for (int i = 1; i <= 100; i++) {
            ps.add(new People(random.get(i), i));
        }

        System.out.println(ps);

        //得到最后一个人
        People theLast = getLastPeople(ps);
        System.out.println(theLast);
    }

    public static People getLastPeople(List<People> ps){
        if(ps.size()!=1){
            //移除奇数位置上的人
            for(int i=0;i < ps.size();i=i+2){
                ps.remove(i);
                i--;
            }
            getLastPeople(ps);
        }
        //定义最后一个人的对象
        People theLast = ps.get(0);
        return theLast;
    }
}
