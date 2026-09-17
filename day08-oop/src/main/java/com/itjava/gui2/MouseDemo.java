package com.itjava.gui2;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*mouseClicked   鼠标点击
mousePressed   鼠标按下
mouseReleased  鼠标松开
mouseEntered   鼠标进入组件区域
mouseExited    鼠标离开组件区域*/
public class MouseDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("鼠标监听器示例");

        JButton button = new JButton("把鼠标放到我这里");

        button.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标点击了按钮");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("鼠标按下了");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("鼠标松开了");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入按钮");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标离开按钮");
            }
        });

        frame.add(button);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}