package com.itjava.demo6collection;

import java.util.ArrayList;

public class CollectionDemo4 {
    public static void main(String[] args) {
        //目标：掌握Collection的遍历方式二 增强for循环遍历 (能遍历集合和数组)
        ArrayList<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);

        //写法：for(元素的数据类型 局部变量名:数组或集合)
        for (String user : names) {
            System.out.println(user);
        }
    }
}
