package com.itjava.demo4test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo2 {
    //认识Collections工具类 掌握它提供的静态方法
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("张无忌");
//        list.add("周芷若");
//        list.add("赵敏");
//        list.add("张强");
//        list.add("张三丰");
        //Collections批量加数据
        System.out.println("---------Collections批量加数据---------");
        Collections.addAll(list,"张无忌","周芷若","赵敏","张强","张三丰");
        System.out.println(list);

        //Collections打乱集合
        System.out.println("---------Collections打乱集合---------");
        Collections.shuffle(list);
        System.out.println(list);
    }
}
