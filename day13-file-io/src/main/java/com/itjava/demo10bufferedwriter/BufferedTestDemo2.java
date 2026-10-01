package com.itjava.demo10bufferedwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BufferedTestDemo2 {
    public static void main(String[] args) {
        //目标：出师表文件排序
        try (
                //设置缓冲字符输入流管道
                BufferedReader br = new BufferedReader(new FileReader("day13-file-io/test/csb.txt"));
                //设置缓冲字符输出流管道
                BufferedWriter bw = new BufferedWriter(new FileWriter("day13-file-io/test/csb_out.txt"));

        ) {
            //设置字符串集合用来存储文件每一行的内容
            List<String> lines = new ArrayList<>();
            //按行读取文件存入集合中
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            Collections.sort(lines);
            //输出到新的文件中
            for(String wirteLine : lines){
                bw.write(wirteLine);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
