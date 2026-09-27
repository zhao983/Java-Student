package com.itjava.demo2map;

import com.itjava.demo1hashset.Teacher;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo5 {
    public static void main(String[] args) {
        //TreeMap也要设置比较规则
        Map<Teacher,Integer> teachers = new TreeMap<>((o1, o2)->Double.compare(o1.getSalary(),o2.getSalary()));
        teachers.put(new Teacher("老陈", 20, 6232.4),1);
        teachers.put(new Teacher("张三", 18, 3999.5),2);
        teachers.put(new Teacher("老王", 22, 9999.9),3);
        teachers.put(new Teacher("老李", 20, 1999.9),4);
        System.out.println(teachers);
    }
}
