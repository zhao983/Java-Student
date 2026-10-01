package com.itjava.demo11bufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferedWriterDemo1 {
    public static void main(String[] args) {
        // 目标：搞清楚缓冲字符输出流的使用：提升了字符输出流的写字符的性能，多了换行功能
        try (
                //定义一个字符输出流对象，指定写出的目的地
//                Writer fw = new FileWriter("day13-file-io/test/5.txt");  //覆盖式通道
                Writer fw = new FileWriter("day13-file-io/test/5.txt",true);  //非覆盖式通道 追加到文件最后面
                BufferedWriter bw = new BufferedWriter(fw);
        ){

            bw.write('男');  //写一个字符
            bw.newLine();  // 新增的换行功能
            bw.write("ab张三");  //写一个字符串
            bw.newLine();
            bw.flush();  //刷新缓冲区 字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效
            //刷新后流可以继续用
            bw.write("hh");
            bw.newLine();
            //关闭了就不能用了
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
