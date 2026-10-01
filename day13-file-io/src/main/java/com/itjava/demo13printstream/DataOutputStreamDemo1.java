package com.itjava.demo13printstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo1 {
    public static void main(String[] args) {
        //认识特殊数据输出流
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("day13-file-io/test/6.txt"));
                ){
            //可以写入数据的类型
            dos.writeChar('张');
            dos.writeDouble(2.2);
            dos.writeInt(5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
