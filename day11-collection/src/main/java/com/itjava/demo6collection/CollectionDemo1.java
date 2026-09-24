package com.itjava.demo6collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //搞清楚Collection集合的整体特点
        //1.List家族的集合: 有序，可重复，有索引
        List list = new ArrayList<>();
        list.add("Java");
        list.add("Java");
        list.add("C");
        list.add("C++");
        System.out.println(list);

        //2.Set家族集合：无序，不可重复，无索引
        Set set = new HashSet<>();
        set.add("Java");
        set.add("Java");
        set.add("C");
        set.add("C++");
        set.add("Python");
        System.out.println(set);
    }
}
