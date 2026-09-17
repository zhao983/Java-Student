package com.itjava.methon1reference;

import java.util.Arrays;

public class Demo2 {
    //特定类型的方法引用
    //如果Lamdba表达式中只是要调用一些特定类型的实例方法，并且参数列表第一个参数作为方法的主调，后面所有参数都作为方法的入参时，就可以用特定类型的引用
    //需求：有一堆人的名字按升序排列
    public static void main(String[] args) {
        String[] name={"张三","Angle","Fable","boli","Yili","mc","Cj","andy"};
//        Arrays.sort(name);
        //要求忽略大小写
        /*
        Arrays.sort(name, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        */
        //简化
        // Arrays.sort(name, (o1,o2) ->o1.compareToIgnoreCase(o2));
        //再简化
        Arrays.sort(name, String::compareToIgnoreCase);
        /*
        for (int i=0;i< name.length;i++){
            System.out.println(name[i]);
        }
        */

        //简化
        System.out.println(Arrays.toString(name));
    }
}
