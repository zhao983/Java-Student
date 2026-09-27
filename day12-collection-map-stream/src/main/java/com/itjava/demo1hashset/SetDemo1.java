package com.itjava.demo1hashset;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
        //目标：认识Set家族集合的特点
        // 1、创建一个Set集合
//        Set<String> set = new HashSet<>(); // 一行经典代码
        Set<String> set = new LinkedHashSet<>(); // LinkedHashSet 有序，不重复，无索引。
        set.add("鸿蒙");
        set.add("鸿蒙");
        set.add("java");
        set.add("java");
        set.add("电商设计");
        set.add("电商设计");
        set.add("新媒体");
        set.add("大数据");
        System.out.println(set);

        // 2、创建一个TreeSet集合：排序（默认一定要大小升序排序），不重复，无索引。
        Set<Double> set1 = new TreeSet<>();
        set1.add(3.14);
        set1.add(5.6);
        set1.add(1.0);
        set1.add(1.0);
        set1.add(2.0);
        System.out.println(set1);

        System.out.println("--------------");
/*        哈希值
就是一个int类型的随机值，Java中每个对象都有一个哈希值。
Java中的所有对象，都可以调用Obejct类提供的hashCode方法，返回该对象自己的哈希值。
        public int hashCode(): 返回对象的哈希码值
                对象哈希值的特点
同一个对象多次调用hashCode()方法返回的哈希值是相同的。
不同的对象，它们的哈希值大概率不相等，但也有可能会相等(哈希碰撞)。*/
        String s1 = "abc";
        String s2 = "abd";
        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s2.hashCode());
    }
}
