package com.itjava.demo2map;

import java.util.*;

public class MapTestDemo4 {
    public static void main(String[] args) {
        //目标：完成Map集合相关案例：邮票统计
        calc();
    }

    private static void calc() {
        //把80名学生的投票放到一个集合中
        List<String> list = new ArrayList<>();
        //先随机生成投票
        String[] names = {"A", "B", "C", "D"}; //列出景点名称
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(names.length);  //随机获得景点的索引
            list.add(names[index]);
        }

        System.out.println(list);

        //设置Map集合，当找到键景点就加一，否则就设置这个景点为键然后值设为1
        Map<String, Integer> map = new HashMap<>();
        //遍历80张票
        for (String s : list) {
            /*
            //查找有没有这个键
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);  //如果有这个键，就对这个键的值加一
            }else {
                map.put(s,1);  //没有就加入这个键并设为1
            }
            */
            //简化
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }

        //展示结果
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
