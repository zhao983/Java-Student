package com.javademo.demo;

import java.util.Random;

//获得4位和6位的验证码
public class CodeTest3 {
    public static void main(String[] args) {
        System.out.println("四位验证码为："+getCode(4));
        System.out.println("六位验证码为："+getCode(6));
        /*String a = null;
        System.out.println(a); 输出null
        a = a+"b";
        System.out.println(a);  输出nullb */

    }

    public static String getCode(int a){
        String code = "";//定义一个空的字符串可以这样
        for(int i = 0;i < a; i++){
            Random random = new Random();
            //随机生成一个数字，大写字母或者小写字母
            //可以先生成一个随机数决定种类
            int type = random.nextInt(1,4);  //遵循[起始值，结束值）
            //1为数字，2为大写字母，3为小写字母
            switch (type){
                case 1 :
                    code += random.nextInt(0,10);
                    /*ints(5, 1, 4)
                    生成 5 个随机整数
                    每个整数范围是 1 ~ 3*/
                    break;
                case 2 :
                    char ch = (char) ('a'+ random.nextInt(0,26));
                    //数字强制转换为字符，用char（）
                    code += ch;
                    break;
                case 3 :
                    char ch1 = (char) ('A'+ random.nextInt(0,26));
                    code += ch1;
                    break;

            }
        }

        return code;
    }
}
