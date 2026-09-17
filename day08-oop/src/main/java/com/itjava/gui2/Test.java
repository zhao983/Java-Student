package com.itjava.gui2;

import javax.swing.*;
import java.awt.event.*;

public class Test {
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
        //给按钮添加点击事件监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(login,"有人点击了登录");  //跳出一个新窗口显示内容
                System.out.println("有人点击了登录");
            }
        });

        System.out.println("-------------");

        /*KeyListener 则是监听键盘行为。
        它主要监听 3 个动作：
        keyPressed   按键按下
        keyReleased  按键松开
        keyTyped     输入了一个字符*/
        //需求：按上下左右监听事件
        //需要的式给这个Login窗口创建监听对象，而不是给面板或者按钮
        login.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {   //keyPressed 按键按压监听
                int keyCode = e.getKeyCode();  //获取按键操作码

                //判断按键的上下左右
                if(keyCode==KeyEvent.VK_UP){
                    System.out.println("用户点击了上");
                } else if (keyCode==KeyEvent.VK_DOWN) {
                    System.out.println("用户点击了下");
                } else if (keyCode==KeyEvent.VK_LEFT) {
                    System.out.println("用户点击了左");
                } else if (keyCode==KeyEvent.VK_RIGHT) {
                    System.out.println("用户点击了右");
                }else {
                    System.out.println("用户点击了其他按键");
                }


            }
        });

        //需要让窗口成为焦点
        login.requestFocus();

    }
}
