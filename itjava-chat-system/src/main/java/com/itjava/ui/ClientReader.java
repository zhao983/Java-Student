package com.itjava.ui;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientReader extends Thread {
    private Socket socket;

    private DataInputStream dis;

    private ChatRoomFrame chatRoomFrame;

    public ClientReader(Socket socket, ChatRoomFrame chatRoomFrame) {
        this.socket = socket;
        this.chatRoomFrame = chatRoomFrame; //把聊天页面传过来，以便互相对数据和页面进行处理
    }

    @Override
    public void run() {
        //3.获取输入流
        try {
            // 接收的消息可能有很多种类型：1、登录消息（包含昵称） 2、群聊消息
            // 先从socket管道中接收客户端发送来的消息类型编号
            dis = new DataInputStream(socket.getInputStream());
            //把消息接受放到死循环，因为还要接受多次消息的发送
            while (true) {
                int type = dis.readInt();

                switch (type) {
                    case 1:
                        //服务端发来的在线人数消息 1
                        updateOnlineUserList(dis);
                        break;
                    case 2:
                        // 服务端发来了群聊消息 2
                        getMsgToChat();
                        break;
                    default:
                        System.out.println("消息格式错误");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getMsgToChat() throws Exception {
        //接受群聊消息
        String msg = dis.readUTF();
        //交给聊天窗口对象处理
        chatRoomFrame.appendMessage(msg);
    }

    private void updateOnlineUserList(DataInputStream dis) throws Exception {
        //更新客户端在线人数列表
        // 1、读取有多少个在线用户
        int count = dis.readInt();
        // 2、循环控制读取多少个用户信息。
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            //读取每个用户的信息
            String name = dis.readUTF();
            //将这些名字放到数组中去
            names[i] = name;
        }
        // 3、更新到窗口界面上的右侧展示出来。
        chatRoomFrame.updateUserCount(names);
    }
}
