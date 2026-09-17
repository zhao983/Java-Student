package com.itjava.stringdemo;

import java.util.Scanner;

public class StringDemo1 {
    // 目标：掌握创建字符串对象，封装要处理的字符串数据，调用String提供的方法处理字符串。
    public static void main(String[] args) {
        //推荐方式一： 直接""就可以创建字符串对象，封装字符串数据。
        String name = "张三";
        System.out.println(name);
        System.out.println(name.length());

        //方式二，通过构造器初始化对象
        String name2 = new String();
        //等效于 String name2 = "";
        System.out.println(name2);

        String name3 = new String("李四");
        System.out.println(name3);

        char[] ch = {'张', '三'};
        String ch1 = new String(ch);
        System.out.println(ch1);

        System.out.println("-------------------");
        /*String创建对象的区别
        只要是以“...”方式写出的字符串对象，会存储到字符串常量池，且相同内容的字符串只存储一份；
        通过new方式创建字符串对象，每new一次都会产生一个新的对象放在堆内存中。*/
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);  //输出true
        //节约内存
        String ss1 = new String("abc");
        String ss2 = new String("abc");
        System.out.println(ss1 == ss2);  //输出false

        String okLoginName = "admin";
        //字符串千万不要用 == 取比较是否相同，因为 == 默认比较的是地址
        Scanner sc = new Scanner(System.in);
        String loginName = sc.next();
        if(loginName.equals(okLoginName)){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }

        String phoneNumber = "12345678900";
        System.out.println(phoneNumber.substring(0,3)+"****"+phoneNumber.substring(7));

    }
}
