package com.itjava.demo3charset;

public class CharSetDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：掌握字符的编码和解码

        String name = "张三666";
        //把字符编译成字节
//        byte[] bytes = name.getBytes(); //默认用平台指定的方法编码
        byte[] bytes = name.getBytes("GBK");  //可以指定编码方式  GBK中汉字占2字节，数字字母占1字节
        System.out.println(bytes.length);  //输出 7

        //把字节解码成字符
//        String name2 = new String(bytes);
//        System.out.println(name2); //输出����666  默认用平台指定的方式解码   张三 占四个字节，刚好有4个�
        String name2 = new String(bytes,"GBK");  //指定解码方式
        System.out.println(name2);

    }

}
