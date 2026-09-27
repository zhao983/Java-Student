package com.itjava.demo3stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        //目标：认识Stream流，掌握其基本用法
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        // 1、先用传统方案：找出姓张的人，名字为3个字的，存入到一个新集合中去。
        List<String> newList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张") && name.length() == 3) {
                newList.add(name);
            }
        }
        System.out.println(newList);

        System.out.println("----------------");

        //2.使用Stream流       需要调用Stream方法    filter用来筛选                                                        collect(Collectors.toList()
        //                 相当于把list放到一个流上  先筛选开头是 张 的人                   再筛选长度为3的                     用来把筛选完的收集到前面定义的集合中
        List<String> newList2 = list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).collect(Collectors.toList());
        System.out.println(newList2);
    }
}
