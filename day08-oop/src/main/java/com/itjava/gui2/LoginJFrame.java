package com.itjava.gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//让这个类继承JFrame，同时实现ActionListener (事件监听器) 接口
public class LoginJFrame extends JFrame implements ActionListener {

    public LoginJFrame(){
        //设置标题
        this.setTitle("登录页面");
        //设置尺寸
        this.setSize(300,200);
        //居中显示
        this.setLocationRelativeTo(null);
        //关闭窗口的同时关闭程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //初始化上述组件
        init();


    }

    public void init(){
        //添加一个登录按钮
        JButton jButton = new JButton("登录");

        //当前窗口对象添加面板
        JPanel jPanel = new JPanel();
        this.add(jPanel);

        jPanel.add(jButton);
        jButton.addActionListener(this);  //因为当前窗口也实现哪里事件监听器，所以可以直接用this
        //这里当监听器用
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this,"有人点击了按钮");
        //这里当窗口用
    }
}
