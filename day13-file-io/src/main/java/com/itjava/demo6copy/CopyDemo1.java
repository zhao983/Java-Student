package com.itjava.demo6copy;

import java.io.*;

public class CopyDemo1 {
    public static void main(String[] args) {
        // 目标：使用字节流完成文件的复制操作。
        // 源文件：1.jpg
        // 目标文件：1_new.jpg （复制过去的时候必须带文件名的，无法自动生成文件名。）             这里写上文件名
        copyFile("day13-file-io/test/1.png","day13-file-io/test/a/b/1_new.jpg");

    }

    private static void copyFile(String srcPath,String destPath) {

        //认识资源的释放方式(资源：一般是指最终实现了AutoCloseable接口)   字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效
        try (   //这里面会自动释放资源   调用.close()方法
                //创建一个字节输入和输出流与源文件接通
                InputStream fis = new FileInputStream(srcPath);
                OutputStream fos = new FileOutputStream(destPath);
                Test test = new Test();

                //这里面只能放资源
//                int a = 1;  报错
                ){
            //读入一个字节数组，输入一个字节数组

            byte[] buffer = new byte[1024];
            int len;
            while ((len= fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Test implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("调用了close()方法");
    }
}