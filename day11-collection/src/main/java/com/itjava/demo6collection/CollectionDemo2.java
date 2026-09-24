package com.itjava.demo6collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        // 目标：搞清楚Collection提供的通用集合功能。
        Collection<String> list = new ArrayList<>();

        // 添加元素
        list.add("张三");
        list.add("李四");
        list.add("王五");
        System.out.println(list); // [张三, 李四, 王五]

        // 获取集合的元素个数
        System.out.println(list.size());

        //删除集合元素
        list.remove("张三");

        //判断集合是否包含某元素
        System.out.println(list.contains("李四"));

        //把集合转换成数组
        Object[] object = list.toArray();
//        System.out.println(object.toString());   //错误写法
        System.out.println(Arrays.toString(object));

        //把集合转换成字符串数组
        String[] obj = list.toArray(String[]::new);
        System.out.println(Arrays.toString(obj));


        //清空集合元素
        list.clear();
        System.out.println(list);
    }
}
