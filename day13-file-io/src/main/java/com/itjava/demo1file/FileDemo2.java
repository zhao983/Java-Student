package com.itjava.demo1file;

import java.io.File;
import java.util.Arrays;

public class FileDemo2 {
    public static void main(String[] args) {
        /**  使用listFile方法的一些注意事项
         * 当主调是文件，或者路径不存在时，返回null
         * 当主调是空文件夹时，返回一个长度为0的数组
         * 当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回
         * 当主调是一个文件夹，且里面有隐藏文件时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
         * 当主调是一个文件夹，但是没有权限访问该文件夹时，返回null
         */

        File f1 = new File("day13-file-io/com.itjava.demo1file/test/1.txt");
        File[] f1s = f1.listFiles();
        System.out.println(f1s);  //当主调是文件，或者路径不存在时，返回null

        File f2 = new File("day13-file-io/com.itjava.demo1file/test/1");
        File[] f2s = f2.listFiles();
        System.out.println(Arrays.toString(f2s));
    }
}
