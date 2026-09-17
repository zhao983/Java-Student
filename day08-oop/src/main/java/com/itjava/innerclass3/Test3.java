package com.itjava.innerclass3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
//    目标：搞清楚几个匿名内部类的使用场景。
//    需求：创建一个登录窗口，窗口上只有一个登录按钮
    public static void main(String[] args) {  //别忘写main方法
        JFrame login =new JFrame("登录页面");  //窗口
        login.setSize(300,200);
        login.setLocationRelativeTo(null);  //居中显示
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口的同时关闭程序
        login.setVisible(true);

        JPanel panel = new JPanel(); //面板
        login.add(panel); //把面板加到窗口上

        JButton btn =new JButton("登录");  //按钮
        panel.add(btn);


        // 开发中不是我们要主动去写匿名内部类，而是用别人的功能的时候，别人可以让我们写一个匿名内部类

        //java要求必须给这个按钮添加一个点击事件监听器对象，这样就可以监听用户的点击操作，然后做出反应
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("用户点击了按钮");
            }
        });   //这个是个接口

//      btn.addActionListener(e -> System.out.println("用户点击了按钮"));

        /*public interface ActionListener extends EventListener {

            *//**
             * Invoked when an action occurs.
             * @param e the event to be processed
             *//*
            public void actionPerformed(ActionEvent e);

        }*/



    }
}
