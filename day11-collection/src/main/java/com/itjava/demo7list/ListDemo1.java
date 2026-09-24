package com.itjava.demo7list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        //增删少查询多用ArrayList
        List<String> names = new ArrayList<>();
        //ArrayList在第一次添加对象时才会创建一个长度为10的数组，加满了会扩容到原来的1.5倍
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names); // [张三, 李四, 王五, 赵六]

        // 给第三个位置插入一个数据：赵敏
        names.add(2, "赵敏");
        System.out.println(names);

        // 删除李四
        System.out.println(names.remove(1)); // 根据下标删除，返回删除的数据
        System.out.println(names);

        // 把王五修改成：金毛
        System.out.println(names.set(2, "金毛")); // 根据下标修改，返回修改前的数据
        System.out.println(names);

        // 获取张三
        System.out.println(names.get(0));

        //三种遍历
        //1.迭代器遍历
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("---------------------");

        //2.增强for循环
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("----------------------");

        //3.Lambda遍历
        names.forEach(s -> {
            System.out.println(s);
        });

    }
}
