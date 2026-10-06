package com.itjava.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatRoomFrame extends JFrame {

    // 消息展示框（聊天记录）
    private JTextArea messageArea;
    // 消息发送框
    private JTextField inputField;
    // 在线用户列表模型
    private DefaultListModel<String> userListModel;
    public JList<String> userList;


    // 当前昵称
    private String nickname;
    //聊天管道
    private Socket socket;

    public ChatRoomFrame() {

    }

    // 构造方法
    public ChatRoomFrame(String nickname, Socket socket) {
        this.nickname = nickname;
        this.socket = socket;

        // 1. 初始化窗口基本属性
        initFrame();

        // 2. 初始化组件和布局
        initView();

        // 3. 设置窗口可见
        this.setVisible(true);

        //立刻把客户端的这个管道送到一个独立的线程中去处理
        new ClientReader(socket, this).start();
    }

    private void initFrame() {
        this.setTitle("局域网群聊 - 当前用户：" + nickname);
        this.setSize(700, 500); // 宽700，高500
        this.setLocationRelativeTo(null); // 居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // 使用边界布局
    }

    private void initView() {
        // ==================== 1. 中间区域（聊天记录 + 发送区） ====================
        JPanel centerPanel = new JPanel(new BorderLayout());

        // --- 上面：消息展示框 (JTextArea + JScrollPane) ---
        messageArea = new JTextArea();
        messageArea.setEditable(false); // 禁止编辑聊天记录
        messageArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        messageArea.setLineWrap(true); // 自动换行
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setBorder(new TitledBorder("聊天记录"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // --- 下面：消息发送框 + 发送按钮 ---
        JPanel sendPanel = new JPanel(new BorderLayout(5, 5)); // 水平间距5
        sendPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // 留点边距

        inputField = new JTextField();
        inputField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        sendPanel.add(inputField, BorderLayout.CENTER);

        JButton sendButton = new JButton("发送");
        sendButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        sendButton.setPreferredSize(new Dimension(80, 30)); // 设置按钮大小
        sendPanel.add(sendButton, BorderLayout.EAST);

        centerPanel.add(sendPanel, BorderLayout.SOUTH);

        // 将中间面板加入主窗口
        this.add(centerPanel, BorderLayout.CENTER);

        // ==================== 2. 右侧区域（在线人数展示） ====================
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(150, 0)); // 固定宽度150
        rightPanel.setBorder(new TitledBorder("在线用户"));

        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        userList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane userScrollPane = new JScrollPane(userList);
        rightPanel.add(userScrollPane, BorderLayout.CENTER);

//        // 底部显示具体人数
//        JLabel countLabel = new JLabel("在线人数：0 人", SwingConstants.CENTER);
//        countLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
//        rightPanel.add(countLabel, BorderLayout.SOUTH);

        // 将右侧面板加入主窗口
        this.add(rightPanel, BorderLayout.EAST);

        // ==================== 3. 绑定事件监听器 ====================

        // 发送按钮点击事件
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // 输入框回车事件
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

    }

    /**
     * 发送消息的逻辑
     */
    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (msg.isEmpty()) {
            return;
        }

        // 1. 展示到自己的聊天框
//        appendMessage(nickname + "：" + msg);

        // 2. TODO: 这里对接你的 Socket 代码，将 msg 发送给服务器
        //从socket管道获取一个特殊数据输出流
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(2); //表示发送的是群聊消息
            dos.writeUTF(msg);
            dos.flush(); //刷新
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 清空输入框
        inputField.setText("");
    }

    /**
     * 向聊天记录追加消息（线程安全方法）
     *
     * @param text 要追加的消息
     */
    public void appendMessage(String text) {
        // 确保在事件分发线程中更新UI
        SwingUtilities.invokeLater(() -> {
            messageArea.append(text + "\n");
            // 滚动到底部
            messageArea.setCaretPosition(messageArea.getDocument().getLength());
        });
    }

    /**
     * 添加在线用户
     */
    public void addUser(String user) {
        if (!userListModel.contains(user)) {
            userListModel.addElement(user);
        }
    }

    /**
     * 移除在线用户
     */
    public void removeUser(String user) {
        userListModel.removeElement(user);
    }

    /**
     * 更新在线人数标签
     */
    public void updateUserCount(String[] names) {
        //把线程读取到的名称展示到页面上
        userList.setListData(names);
    }


}