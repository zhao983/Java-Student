package com.itjava.gui;

import javax.swing.*;

public class BoxLayoutDemo1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout");

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //Y_AXIS竖着排  X_AXIS横着排

        panel.add(new JButton("按钮1"));
        panel.add(Box.createVerticalStrut(10));  //两个按钮间设置10的距离
        panel.add(new JButton("按钮2"));
        panel.add(Box.createVerticalStrut(10));  //两个按钮间设置10的距离
        panel.add(new JButton("按钮3"));

        frame.add(panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
