package com.itjava.demo9bufferedinputstream;


import java.io.*;

public class BufferedIputStreamDemo1 {
    public static void main(String[] args) {
        //目标：认识缓冲字节输入/输出流   默认有一个8k的缓冲区
        copyFile("day13-file-io/test/1.png","day13-file-io/test/a/b/2_new.jpg");

    }

    private static void copyFile(String srcPath,String destPath) {

        //认识资源的释放方式(资源：一般是指最终实现了AutoCloseable接口)   字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效
        try (   //这里面会自动释放资源   调用.close()方法

                //创建一个字节输入和输出流与源文件接通
                InputStream fis = new FileInputStream(srcPath);
                //把低级的字节输入流包装成高级的缓冲字节输入流
                BufferedInputStream bis = new BufferedInputStream(fis);
                //把低级的字节输出流包装成高级的缓冲字节输出流
                OutputStream fos = new FileOutputStream(destPath);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                //这里面只能放资源
//                int a = 1;  报错
        ){
            //读入一个字节数组，输入一个字节数组

            byte[] buffer = new byte[1024];
            int len;
            while ((len= bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
