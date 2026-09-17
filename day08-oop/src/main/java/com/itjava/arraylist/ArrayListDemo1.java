package com.itjava.arraylist;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        //目标：掌握ArrayList集合的基本使用
//        ArrayList name =new ArrayList<>();
        ArrayList<String> name = new ArrayList<>(); //在ArrayList后面加上<数据类型>,可以只让该集合只能传输这一个数据
        //添加数据
        name.add("张三");
        name.add("李四");
        name.add("王五");
        name.add("赵六");
        //查看数据
        System.out.println(name.get(0)); //根据索引查看
        System.out.println(name.get(1));
        System.out.println(name.get(2));
        System.out.println(name.get(3));
        System.out.println(name);
        //删除数据
        name.remove(0); //根据索引
        name.remove("王五");//根据内容
        System.out.println(name);
        //修改数据
        name.set(0,"唐七");
        System.out.println(name);
    }
}
