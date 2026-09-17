package com.itjava.gui;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout");

        frame.setLayout(new BorderLayout());

        frame.add(new JButton("北"), BorderLayout.NORTH);
        frame.add(new JButton("南"), BorderLayout.SOUTH);
        frame.add(new JButton("西"), BorderLayout.WEST);
        frame.add(new JButton("东"), BorderLayout.EAST);
        frame.add(new JButton("中"), BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
