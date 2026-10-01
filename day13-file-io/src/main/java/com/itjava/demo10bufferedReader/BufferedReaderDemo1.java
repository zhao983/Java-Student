package com.itjava.demo10bufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        //目标：掌握缓冲字符输入流读取文件
        try (
                Reader fr = new FileReader("day13-file-io/test/4.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
//            char[] chs = new char[3];    //用的是char 而不是 byte
//            int len;
//            while ((len=br.read(chs))!=-1){
//                String str = new String(chs,0,len);
//                System.out.print(str);  //会读取换行符，所以不用println

            //BufferedReader 提供了按行读取的方法 当无内容时返回null
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }    //现在一般都是按这种方式读取
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
