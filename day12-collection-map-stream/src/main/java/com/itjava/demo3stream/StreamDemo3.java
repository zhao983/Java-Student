package com.itjava.demo3stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        //掌握Stream流常用的中间方法
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //1.过滤方法
        list.stream().filter(s -> s.startsWith("张") && s.length() == 3).forEach(System.out::println);

        System.out.println("----------------");

        //2.排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(99.5);
        scores.add(69.5);
        scores.add(89.5);
        scores.add(59.5);
        scores.add(99.5);

        scores.stream().sorted().forEach(System.out::println);  //默认升序
        System.out.println("----------------");
        //可自定义为降序
//        scores.stream().sorted((o1,o2)-> o2.compareTo(o1)).forEach(System.out::println);
        scores.stream().sorted((o1,o2)-> Double.compare(o2,o1)).forEach(System.out::println);

        System.out.println("----------------");
        //降序完后只要前两名
        scores.stream().sorted((o1,o2)-> Double.compare(o2,o1)).limit(2).forEach(System.out::println);
        System.out.println("----------------");
        //降序完后不要前两名
        scores.stream().sorted((o1,o2)-> Double.compare(o2,o1)).skip(2).forEach(System.out::println);
        System.out.println("----------------");
        //去重复
        scores.stream().sorted((o1,o2)-> Double.compare(o2,o1)).skip(2).distinct().forEach(System.out::println);
        System.out.println("----------------");

        //映射/加工 方法
        scores.stream().map(s->"每一个加十分"+(s+10)).forEach(System.out::println);
        System.out.println("----------------");

        //合并流
        Stream<Object> concat = Stream.concat(list.stream(), scores.stream());
        System.out.println(concat.count());
    }
}
