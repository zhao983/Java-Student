package com.itjava.demo2recursion;

import java.io.File;

public class FileSearchDemo2 {
    public static void main(String[] args) {
        //目标：完成文件搜索，找到D盘下的QQ.exe文件路径
        //先设置D盘文件夹对象
        File file = new File("D:/");
        searchFile(file, "QQ.exe");
    }

    private static void searchFile(File file, String fileName) {
        //先判断文件夹是否为空或者里面没有文件,或者传过来的文件夹其实是文件 这样就不搜索
        if (file == null || !file.exists() || file.isFile()) {
            System.out.println("传入路径有问题");
            return;
        }

        //获取该目录下的所有文件和文件夹
        File[] files = file.listFiles();
        //判断当前目录下是否存在一级文件/文件夹
        if (files != null && files.length > 0) {
            //遍历每一个文件
            for (File file1 : files) {
                if (file1.isFile()) {
                    if (file1.getName().equals(fileName)) {
                        //如果符合就输出路径并终止搜寻
                        System.out.println(file1.getAbsolutePath());
//                        return;  //能结束当前这一层 searchFile() 方法调用，不能保证整个递归搜索立刻全部结束。
                    }
                //如果该文件其实是文件夹，则再一次调用该方法
                } else {
                    searchFile(file1, fileName);
                }
                //否则就判断这个是否符合条件

            }
        }


    }
}
