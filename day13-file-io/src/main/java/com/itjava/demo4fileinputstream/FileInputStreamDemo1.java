package com.itjava.demo4fileinputstream;

import java.io.FileInputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        // 目标：掌握文件字节输入流读取文件中的字节数组到内存中来。
        // 1、创建文件字节输入流管道于源文件接通
        FileInputStream is = new FileInputStream("day13-file-io/test/1.txt");
        is.close();
        /*//开始读字节并输出
        int b;
        while ((b= is.read())!=-1){  //当read读到空时，输出-1
//            System.out.print(b);  //输出ASC码值
            System.out.print((char) b);

        }*/  //每次只读取一个字节，性能较差，且读汉字的时候一定会出错

        FileInputStream is2 = new FileInputStream("day13-file-io/test/2.txt");
        //定义一个字节数用于每次读取字节
        byte[] bytes = new byte[3];
        int len;
        while ((len= is2.read(bytes))!=-1){
            /*
            String str = new String(bytes,0,len);
            System.out.println(str);   //这样会输出 wda dda 因为这个每次读取三个字节,所有应该指定读取到的字节长度*/
            String str = new String(bytes,0,len);
            System.out.println(str);
        } //每次读取多个字节，性能得到提升，因为每次读取多个字节，可以减少硬盘和内存的交互次数，从而提升性能
        //但依然可能会出现汉字   乱码问题，存在阶段汉字的可能
        is2.close();

        //一次性读所有字节  能避免乱码问题
        System.out.println("------一次性读所有字节-------");
        FileInputStream is3 = new FileInputStream("day13-file-io/test/3.txt");
        byte[] bytes1 = is3.readAllBytes();
        String str2 = new String(bytes1);
        System.out.println(str2);
        is3.close();

    }
}
