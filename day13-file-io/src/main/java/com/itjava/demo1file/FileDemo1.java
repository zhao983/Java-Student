package com.itjava.demo1file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        // 目标：创建File创建对象代表文件（文件/目录），搞清楚其提供的对文件进行操作的方法。
        // 1、创建File对象，去获取某个文件的信息
        File f1 = new File("day13-file-io/test/1.txt");
//        File f11 = new File("day13-file-io\\test\\1.txt"); //可以用正斜杠或者单反斜杠

        System.out.println(f1.length());  //获取文件字节个数
        System.out.println(f1.exists());  //判断是否存在
        System.out.println(f1.getName()); //获取文件名
        System.out.println(f1.isFile());  //判断是否是文件
        System.out.println(f1.isDirectory());  //判断是否是文件夹

        //创建对象代表不存在的文件路径
        File f2 = new File("day13-file-io/test/2.txt");
        System.out.println(f2.createNewFile());

        //创建对象代表不存在的文件夹路径
        File f3 = new File("day13-file-io/test/a");
        System.out.println(f3.mkdir());  //只能创造一级文件夹
        File f4 = new File("day13-file-io/test/a/b/c");
        System.out.println(f4.mkdirs()); //能创造多级文件夹

        //删除文件夹
        File f5 = new File("day13-file-io/test/a/b/c");
        System.out.println(f5.delete());

        //获取某个目录下的一级文件名放到数组中去
        File f6 = new File("day13-file-io/test/");
        String[] f6s = f6.list();
        System.out.println(Arrays.toString(f6s));
        //获取某个目录下的一级文件名放到对象数组中去
        File[] files = f6.listFiles();
        for(File file : files){
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());  //拿绝对路径
        }
    }
}
