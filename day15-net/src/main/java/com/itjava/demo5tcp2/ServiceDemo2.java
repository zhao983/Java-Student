package com.itjava.demo5tcp2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceDemo2 {
    public static void main(String[] args) throws Exception {
        //目标：实现TCP协议下的多发多收 服务端开发
        //1.创建服务端ServiceSocket对象，绑定端口号
        ServerSocket ss = new ServerSocket(9999);

        // 2、调用accept方法，阻塞等待客户端连接，一旦有客户端链接会返回一个Socket对象
        Socket socket = ss.accept();
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.把字节输入流包装成与客户端相同的数据流
        DataInputStream dis = new DataInputStream(is);

        //这里加上死循环
        while (true) {
            //5.读取数据
            int id = dis.readInt();
            String msg = dis.readUTF();
            System.out.println("id:" + id + "\t" + "msg:" + msg);

            //客户端IP和端口
            System.out.println("IP:"+socket.getInetAddress().getHostAddress()+"\t"+"端口:"+socket.getPort());
        }
    }
}
