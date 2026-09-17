package com.itjava.gui;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo1 {
    public static void main(String[] args) {
        //水平流式布局，一行满了自动切换下一行
        JFrame frame = new JFrame("FlowLayout");

        frame.setLayout(new FlowLayout());

        frame.add(new JButton("按钮1"));
        frame.add(new JButton("按钮2"));
        frame.add(new JButton("按钮3"));
        frame.add(new JButton("按钮4"));
        frame.add(new JButton("按钮5"));
        frame.add(new JButton("按钮6"));
        frame.add(new JButton("按钮7"));

        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口的同时关闭程序
    }
}
