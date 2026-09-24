package com.itjava.demo6collection;

import java.util.ArrayList;

public class CollectionDemo5 {
    public static void main(String[] args) {
        //目标：掌握Collection的遍历方式三 Lambda
        ArrayList<String> names = new ArrayList<>();
        //ArrayList在第一次添加对象时才会创建一个长度为10的数组，加满了会扩容到原来的1.5倍
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);

        //需要先调用foreach方法
//        names.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        //简化
        names.forEach(s -> System.out.println(s));
        System.out.println("-----------------");
        //再简化
        names.forEach(System.out::println);


    }
}
