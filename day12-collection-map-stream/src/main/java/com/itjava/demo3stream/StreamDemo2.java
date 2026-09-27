package com.itjava.demo3stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //目标：掌握获取Stream流的方式
        //1.Set集合获取Stream流 直接调用stream方法
        Collection<String> collection = new ArrayList<>();
        Stream<String> s1 = collection.stream();

        //2.Map集合获取Stream流
        //(1) 获取键值，根据键值设置Stream流  获取键流
        Map<String, Integer> map = new HashMap<>();
        Stream<String> s2 = map.keySet().stream();
        //(2) 获取值流
        Stream<Integer> s3 = map.values().stream();
        //(3)获取键值对流
        Stream<Map.Entry<String,Integer>> s4 = map.entrySet().stream();

        //3.数组获取Stream流
        String[] names = {"张三","李四","王五"};
        Stream<String> s5 = Arrays.stream(names);
        System.out.println(s5.count());  //拿流的个数
        Stream<String> s6 = Stream.of(names);
        Stream<String> s7 = Stream.of("张三","李四","王五");
    }
}
