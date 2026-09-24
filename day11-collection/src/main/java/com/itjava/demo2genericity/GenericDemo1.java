package com.itjava.demo2genericity;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
        //认识泛型，搞清楚泛型的作用
        ArrayList<String> list = new ArrayList<String>();
        list.add("wds");
        list.add("ss");
//        list.add(13);
//        list.add(13.2);
//        list.add('a');

        for (int i = 0;i<list.size();i++){
//            Object rs = list.get(i);
//            //把数据转换类型
//            String s =(String) rs;
//            System.out.println(list.get(i));
            String s =(String) list.get(i);
            System.out.println(s);

        }

    }


}
