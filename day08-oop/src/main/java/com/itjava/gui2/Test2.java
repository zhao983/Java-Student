package com.itjava.gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//认识事件常用的几种写法
public class Test2 {
    public static void main(String[] args) {
        JFrame login =new JFrame("登录页面");  //窗口
//        login.setTitle("登录页面");
        login.setSize(300,200);
        login.setLocationRelativeTo(null);  //居中显示


        JPanel panel = new JPanel(); //面板
        login.add(panel); //把面板加到窗口上

        JButton btn =new JButton("登录");  //按钮
        panel.add(btn);
        //给按钮添加点击事件监听器
        btn.addActionListener(new MyActionListener(login));

        //推荐先把窗口内容搭完，最后再显示窗口。
        login.setVisible(true);
        //关闭窗口的同时关闭程序
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//1.直接提供实现类(实现事件监听器接口)，用于创建事件监听对象
class MyActionListener implements ActionListener{
    private JFrame login;
    public MyActionListener(JFrame login){
        this.login=login;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(login,"有人点击了登录");
    }
}
