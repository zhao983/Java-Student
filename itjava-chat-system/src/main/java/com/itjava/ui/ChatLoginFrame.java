package com.itjava.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatLoginFrame extends JFrame {

    private Socket socket;

    public ChatLoginFrame() {
        // 1. 初始化窗口基本属性
        initFrame();

        // 2. 初始化界面组件
        initView();

        // 3. 设置窗口可见
        this.setVisible(true);
    }

    private void initFrame() {
        this.setTitle("局域网聊天 - 登录");
        this.setSize(320, 220); // 设置合适的宽高
        this.setLocationRelativeTo(null); // 居中显示
        this.setLayout(null); // 使用绝对布局，方便精准控制位置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口即退出程序
        this.setResizable(false); // 禁止改变窗口大小
    }

    private void initView() {
        // --- 昵称标签 ---
        JLabel nameLabel = new JLabel("昵称：");
        nameLabel.setBounds(40, 40, 60, 30);
        this.add(nameLabel);

        // --- 昵称输入框 ---
        JTextField nameField = new JTextField();
        nameField.setBounds(100, 40, 150, 30);
        this.add(nameField);

        // --- 进入按钮 ---
        JButton enterButton = new JButton("进入");
        enterButton.setBounds(50, 110, 80, 35);
        // 设置快捷键：按回车键也能触发
        this.getRootPane().setDefaultButton(enterButton);
        this.add(enterButton);

        // --- 取消按钮 ---
        JButton cancelButton = new JButton("取消");
        cancelButton.setBounds(170, 110, 80, 35);
        this.add(cancelButton);

        // --- 绑定事件监听器 ---

        // 1. 进入按钮事件
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = nameField.getText().trim();
                if (nickname.isEmpty()) {
                    JOptionPane.showMessageDialog(ChatLoginFrame.this, "昵称不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (nickname.length() > 10) {
                    JOptionPane.showMessageDialog(ChatLoginFrame.this, "昵称不能超过10个字符！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // TODO: 这里可以进入后续的 Socket 连接逻辑
                // 例如：new ChatRoomFrame(nickname).setVisible(true);
                JOptionPane.showMessageDialog(ChatLoginFrame.this, "欢迎进入聊天室：" + nickname);
                //进入聊天室逻辑
                try {
                    //登录
                    login(nickname);
                    //启动聊天页面
                    new ChatRoomFrame(nickname,socket);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // 登录成功后关闭当前界面
                dispose();
            }
        });

        // 2. 取消按钮事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 退出程序
                System.exit(0);
            }
        });
    }

    private void login(String nickname) throws Exception {
        //立刻发送登录消息给服务端程序
        //1.创建Socket管道
        socket = new Socket(Constant.SERVER_IP,Constant.SERVER_PORT);
        //2.立刻发送 消息类型1 和自己的名称给服务端
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());  //创建数据输出流管道
        dos.writeInt(1);
        dos.writeUTF(nickname);
        dos.flush(); //刷新
    }


}