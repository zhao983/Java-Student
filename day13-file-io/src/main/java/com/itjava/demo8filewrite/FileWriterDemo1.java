package com.itjava.demo8filewrite;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo1 {
    public static void main(String[] args) {
        //目标：搞清楚字符输出流的使用，写字符出去的流
        try (
                //定义一个字符输出流对象，指定写出的目的地
//                Writer fw = new FileWriter("day13-file-io/test/5.txt");  //覆盖式通道
                Writer fw = new FileWriter("day13-file-io/test/5.txt",true);  //非覆盖式通道 追加到文件最后面
                ){

            fw.write('男');  //写一个字符
            fw.write("\r\n");  //换行
            fw.write("ab张三");  //写一个字符串
            fw.write("\r\n");
            fw.flush();  //刷新缓冲区 字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效
            //刷新后流可以继续用
            fw.write("hh");
            //关闭了就不能用了
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
