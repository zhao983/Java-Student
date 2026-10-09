package com.itjava.demo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        // 1、定义水对象存储每种液体数据
// 2、定义一个List集合存储每种液体对象
        Liquid water = new Liquid("水", 4, 24);
        Liquid milk = new Liquid("牛奶", 8, 160);
        Liquid wine = new Liquid("五粮液", 2, 4000);
        Liquid cola = new Liquid("可乐", 6, 108);
        Liquid maotai = new Liquid("茅台", 1, 4000);
        List<Liquid> liquids = new ArrayList<>(); // 8分
        Collections.addAll(liquids, water, milk, wine, cola, maotai);

// 3、对List集合按照液体每升单价降序排序。
        liquids = liquids.stream().sorted((o1, o2) -> Double.compare(o2.getOnePrice(), o1.getOnePrice())).collect(Collectors.toList());

// 4、遍历集合，从前往后依次选10升液体，就是最贵的液体。
        double total = 0; // 最高价值
        int all = 10; // 10升

        for (int i = 0; i < liquids.size(); i++) {
            Liquid liquid = liquids.get(i);
            // 判断是否完全达到了10生
            int volume = liquid.getVolume();
            if (volume >= all) {
                System.out.println(liquid.getName() + "提取了" + all + "升");
                total += liquid.getOnePrice() * all;
                break;
            } else {
                System.out.println(liquid.getName() + "提取了" + volume + "升");
                total += liquid.getOnePrice() * volume;
                all -= volume; // 剩余还总共需要多少升
            }
        }
        System.out.println("总价值：" + total);
    }
}
