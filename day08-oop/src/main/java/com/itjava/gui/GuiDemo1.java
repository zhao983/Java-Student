package com.itjava.gui;

import javax.swing.*;

public class GuiDemo1 {
    public static void main(String[] args) {
        JFrame login =new JFrame("登录页面");  //窗口
        login.setSize(300,200);
        login.setLocationRelativeTo(null);  //居中显示
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口的同时关闭程序
        login.setVisible(true);

        JPanel panel = new JPanel(); //面板
        login.add(panel); //把面板加到窗口上

        JButton btn =new JButton("登录");  //按钮
        panel.add(btn);
        btn.addActionListener(e -> System.out.println("用户点击了按钮"));  //简化

    }
}
