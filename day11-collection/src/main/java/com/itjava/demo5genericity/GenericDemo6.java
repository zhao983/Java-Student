package com.itjava.demo5genericity;

import java.util.ArrayList;

public class GenericDemo6 {
    public static void main(String[] args) {
        //目标：搞清泛型和集合不支持基本类型操作，只支持对象类型（引用数据类型）
        //ArrayList<int> list = new ArrayList<>();
        //泛型擦除：泛型工作在编译阶段，在编译阶段结束后泛型就没用了，所以泛型在编译结束后都会被擦除，所有类型都会恢复成Object类型

        //把基本数据类型包装成对象
        Integer it1 = Integer.valueOf(100);
        //java中缓存了-128到127 之间的数据
        Integer it2 = Integer.valueOf(100);
        System.out.println(it1 == it2);  //输出true
        //超过130才会重新开辟空间
        Integer it3 = Integer.valueOf(130);
        Integer it4 = Integer.valueOf(130);
        System.out.println(it3 == it4);  //输出false 地址不一样

        //自动装箱：基本数据类型可以直接变成包装类的对象
        Integer it11 = 100;
        System.out.println(it1 == it11);  //输出true

        //自动拆箱：把包装类的对象直接给基本数据
        int i = it1;
        System.out.println(i);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);  //自动装箱
        int rs = list.get(0); //自动拆箱
        System.out.println(rs);

        System.out.println("------------");
        //包装类的功能
        //1.把基本数据类型转换为字符串
        int j = 98;
        String rs1 = Integer.toString(j);
        String rs2 = rs1 + 2;
        System.out.println(rs2);  //输出982
        //但还有一种基本数据类型转字符串的方式
        String rs3 = j + "";
        String rs4 = rs1 + 2;
        System.out.println(rs4);  //输出982

        //2.把字符串转基本数据类型 （重要！！！）
        String str = "98";
        int i1 = Integer.valueOf(str);
        System.out.println(i1 + 2);  //输出100

        double i2 = Double.valueOf(str);
        System.out.println(i2 + 2);  //输出100.0

    }
}
