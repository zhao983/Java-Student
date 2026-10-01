package com.itjava.demo12commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class CommonsIonDemo1 {
    public static void main(String[] args) throws Exception {
        /*FileUtils类提供的部分方法展示
        方法名称	说明
        public static void copyFile(File srcFile, File destFile)	复制文件。
        public static void copyDirectory(File srcDir, File destDir)	复制文件夹
        public static void deleteDirectory(File directory)	删除文件夹
        public static String readFileToString(File file, String encoding)	读数据
        public static void writeStringToFile(File file, String data, String charname, boolean append)	写数据
        IOUtils类提供的部分方法展示
        方法名称	说明
        public static int copy(InputStream inputStream, OutputStream outputStream)	复制文件。
        public static int copy(Reader reader, Writer writer)	复制文件。
        public static void write(String data, OutputStream output, String charsetName)	写数据*/
        FileUtils.copyFile(new File("day13-file-io/test/csb.txt"),new File("day13-file-io/test/csb_2.txt"));
        FileUtils.copyDirectory(new File("day13-file-io/test/a/b"),new File("day13-file-io/test/a/c"));  //复制文件夹
    }
}
