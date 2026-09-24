package com.itjava.demo6collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo6 {
    public static void main(String[] args) {
        //目标：认识并发索引修改异常问题，搞清楚每种遍历区别
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        list.add("西洋参");

        //需求一：删除全部枸杞
//        for (int i = 0; i < list.size(); i++) {
//            String names= list.get(i);
//            if(names.contains("枸杞")){
//                list.remove(i);
//            }
//        }
//        System.out.println(list);
        //但这个写法是错误的，结果输出为[Java入门, 黑枸杞, 人字拖, 枸杞子, 西洋参]
        // 原因是每次删除后，后面的内容的索引都会往前，所以接连有两个就会删不了,下面有两种解决方法

        //需求一：删除全部枸杞
        for (int i = 0; i < list.size(); i++) {
            String names = list.get(i);
            if (names.contains("枸杞")) {
                list.remove(i);
                i--;  //删完后索引减一 （前提：支持索引）
            }
        }
        System.out.println(list);

        System.out.println("------------------");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Java入门");
        list2.add("宁夏枸杞");
        list2.add("黑枸杞");
        list2.add("人字拖");
        list2.add("特级枸杞");
        list2.add("枸杞子");
        list2.add("西洋参");

        //需求一：删除全部枸杞
        for (int i = list2.size() - 1; i >= 0; i--) { //解决方法二：倒着遍历并删除（前提：支持索引）
            String names = list2.get(i);
            if (names.contains("枸杞")) {
                list2.remove(i);
            }
        }
        System.out.println(list2);

        System.out.println("------------------");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("Java入门");
        list3.add("宁夏枸杞");
        list3.add("黑枸杞");
        list3.add("人字拖");
        list3.add("特级枸杞");
        list3.add("枸杞子");
        list3.add("西洋参");

        //需求一：删除全部枸杞
        //方案一：迭代器遍历并删除
        //迭代器遍历并删除默认也存在并发修改问题
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            String names = it.next();
            if (names.contains("枸杞")) {
                it.remove();  //用迭代器自己的方式删除即可
            }
        }
        System.out.println(list3);

        System.out.println("------------");

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("Java入门");
        list4.add("宁夏枸杞");
        list4.add("黑枸杞");
        list4.add("人字拖");
        list4.add("特级枸杞");
        list4.add("枸杞子");
        list4.add("西洋参");
        //需求一：删除全部枸杞
        //方案二和三：都不能解决
        //增强for循环
//        for (String s : list) {
//            if(s.contains("枸杞")){
//                list.remove(s);    //增强for循环本质是用迭代器遍历，但这里的迭代器被隐藏了就无法调用
//            }
//        }
//        System.out.println(list4);

        //Lambda
//        list4.forEach(s -> {    //forEach用的是增强for循环遍历
//            if(s.contains("枸杞"));
//            list4.remove(s);
//        });    //会抛出异常 ConcurrentModificationException
//        System.out.println(list4);
    }
}
