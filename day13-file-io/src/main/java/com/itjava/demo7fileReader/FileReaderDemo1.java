package com.itjava.demo7fileReader;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) {
        //目标：掌握字符输入流读取文件输入到程序中来
        //按字符截取，不会出现中文乱码问题，是一种处理中文很好的方案
        try (
                Reader fr = new FileReader("day13-file-io/test/4.txt")
        ) {
            char[] chs = new char[3];    //用的是char 而不是 byte
            int len;
            while ((len=fr.read(chs))!=-1){
                String str = new String(chs,0,len);
                System.out.print(str);  //会读取换行符，所以不用println
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
