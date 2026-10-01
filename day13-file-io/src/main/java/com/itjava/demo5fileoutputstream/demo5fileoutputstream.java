package com.itjava.demo5fileoutputstream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class demo5fileoutputstream {
    public static void main(String[] args) throws Exception {
        //目标：认识字节输出流
//        OutputStream os = new FileOutputStream("day13-file-io/test/4.txt");  //文件不存在会自动创建 但这种写法每次都会覆盖原文件
        OutputStream os = new FileOutputStream("day13-file-io/test/4.txt",true);  //文件不存在会自动创建 每次追加到文件最后

        //写入数据
        os.write('a');  //只能写入一个字节
        os.write(65);
//        os.write('张');  //会乱码
        os.write("\r\n".getBytes());  //写入换行
        //写一个字节数组
        byte[] bytes = "我是张三abc".getBytes(StandardCharsets.UTF_8);
        os.write(bytes);
        os.write("\r\n".getBytes());
    }
}
