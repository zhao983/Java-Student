package com.itjava.demo13printstream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamDemo1 {
    public static void main(String[] args) {
        //认识特殊数据输入流
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("day13-file-io/test/6.txt"));
        ){
            //可以按数据类型读取 特殊数据输入流那边怎么输出这边就怎么输入，否则会出错
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());
            System.out.println(dis.readInt());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
