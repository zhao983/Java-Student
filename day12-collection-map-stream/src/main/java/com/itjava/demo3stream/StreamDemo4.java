package com.itjava.demo3stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    //掌握常用的Stream终结方法
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("老陈", 20, 6232.4));
        teachers.add(new Teacher("张三", 18, 3999.5));
        teachers.add(new Teacher("老王", 22, 9999.9));
        teachers.add(new Teacher("老李", 20, 1999.9));

        //forEach 遍历
        System.out.println("-------forEach 遍历------");
        teachers.stream().filter(s->s.getSalary()>3000).forEach(System.out::println);

        //count 返回个数
        System.out.println("------count 返回个数-------");
        long count = teachers.stream().filter(s -> s.getSalary() > 3000).count();
        System.out.println(count);

        //获得最大  是对象时要指定比较方法
        System.out.println("--------获得最大------");
        Optional<Teacher> max = teachers.stream().max(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())));
        Teacher teacherMax = max.get();
        System.out.println(teacherMax);
        //获得最小
        System.out.println("-------获得最小-------");
        Optional<Teacher> min = teachers.stream().min(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())));
        Teacher teacherMin = min.get();
        System.out.println(teacherMin);


        //收集流
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        //把流收集到数组或集合中
        Stream<String> stringStream1 =list.stream().filter(s -> s.startsWith("张"));

        //收集到数组
        System.out.println("-------收集到数组------");
        Object[] objects = list.stream().toArray();
        System.out.println(Arrays.toString(objects));

        //收集到List集合
        System.out.println("-------收集到List集合------");
        List<String> collect = stringStream1.collect(Collectors.toList());
        System.out.println(collect);
        //收集到Set集合
        System.out.println("-------收集到Set集合------");
//        Set<String> collect1 = stringStream1.collect(Collectors.toSet());  //编译报错，一个流只能用一次 java.lang.IllegalStateException: stream has already been operated upon or closed
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);
        //收集到Map集合，要指定键值对  以名字为键，年龄为值
        System.out.println("---------收集到Map集合--------");
        Map<String,Integer> map = teachers.stream().collect(Collectors.toMap(o->o.getName(),o->o.getAge()));
        System.out.println(map);
    }
}
