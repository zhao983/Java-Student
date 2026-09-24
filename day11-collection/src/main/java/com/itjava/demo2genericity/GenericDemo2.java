package com.itjava.demo2genericity;

public class GenericDemo2 {
    public static void main(String[] args) {
        //学会自定义泛型类
        //模拟ArrayList集合自建一个MyArrayList集合
        MyArrayList<String> list = new MyArrayList<>();  //JDK7以后右边的泛型可以不写
        list.myAdd("Java");
        list.myAdd("it");
        System.out.println(list.myAdd("world"));
        list.myRemove("it");
        System.out.println(list.mytoString());
    }
}
