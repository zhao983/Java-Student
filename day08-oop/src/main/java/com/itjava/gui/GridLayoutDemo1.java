package com.itjava.gui;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout");

        frame.setLayout(new GridLayout(2, 3)); //两行三列

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
