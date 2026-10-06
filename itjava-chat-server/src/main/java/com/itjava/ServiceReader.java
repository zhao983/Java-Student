package com.itjava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServiceReader extends Thread{
    private Socket socket;

    public ServiceReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //3.获取输入流
        try {
            // 接收的消息可能有很多种类型：1、登录消息（包含昵称） 2、群聊消息
            // 所以客户端必须声明协议发送消息
            // 比如客户端先发1，代表接下来是登录消息。
            // 比如客户端先发2，代表接下来是群聊消息。
            // 先从socket管道中接收客户端发送来的消息类型编号
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            //把消息接受放到死循环，因为还要接受多次消息的发送
            while (true) {
                int type = dis.readInt();

                switch (type){
                    case 1 :
                        // 客户端发来了登录消息，接下来要接收昵称数据，再更新全部在线客户端的在线人数列表。
                        String loginName = dis.readUTF();
                        //把得到的管道和名称放入Map集合
                        Server.onLineSocket.put(socket,loginName);
                        //更新在线成员列表
                        updateOnlineUserList();

                        break;
                    case 2:
                        // 客户端发来了群聊消息，接下来要接收群聊消息内容，再把群聊消息转发给全部在线客户端。
                        String msg = dis.readUTF();
                        sendMsgToAll(msg);
                        break;
                    default:
                        System.out.println("消息格式错误");
                }
            }

        }catch (Exception e) {
            //当客户端下线的时候,把这个客户端管道从Map集合中抹去,并再次更新在线列表
            System.out.println("客户端下线了"+socket.getInetAddress().getHostAddress()+"\t"+socket.getPort());
            Server.onLineSocket.remove(socket);
            updateOnlineUserList();

        }
    }

    private void sendMsgToAll(String msg){
        //将发送的消息与用户名，当前时间拼接在一起
        //获取当前时间
        LocalDateTime now =LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH-mm-ss EEE");
        String nowStr = dtf.format(now).toString();

        StringBuilder sb = new StringBuilder();
        String append = sb.append(Server.onLineSocket.values()).append("\t").append(nowStr).append("\n")
                .append(msg).append("\n").toString();

        //再把这些信息推送给所有的在线管道
        for(Socket socket : Server.onLineSocket.keySet()){

            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                //先写要发出去的数据类型
                dos.writeInt(2);  //2 代表群聊消息
                //进行发送
                dos.writeUTF(append);

                //发送完毕后刷新
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void updateOnlineUserList(){
        //更新全部的在线人数
        //拿到当前全部在线客户端名称，把这些名称发给全部的在线客户端管道
        //1.拿到当前全部的客户端名称
        Collection<String> onlineUsers = Server.onLineSocket.values();
        //2.把这个集合中的所有用户推送给全部的客户端Socket管道
        for(Socket socket : Server.onLineSocket.keySet()){

            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                //先写要发出去的数据类型
                dos.writeInt(1);  //1 代表登录消息
                //告诉客户端接下来要发多少用户名字
                dos.writeInt(onlineUsers.size());
                //进行发送
                for(String onlineUser : onlineUsers){
                    dos.writeUTF(onlineUser);
                }

                //发送完毕后刷新
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
