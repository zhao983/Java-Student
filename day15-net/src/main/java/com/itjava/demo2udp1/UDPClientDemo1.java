package com.itjava.demo2udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：完成UDP通讯一发一收，客户端开发
        //1.创建发送端对象
        DatagramSocket socket = new DatagramSocket();  //随机端口
        //2.创建数据包对象封装要发送的数据
        byte[] bytes = "我是客户端".getBytes();
        //四个参数                                  要发送的数据 数据长度     对方IP                   服务端程序端口号
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8080);

        //3.让发送端对象发送数据包数据
        socket.send(packet);

        //发完后关闭资源
        socket.close();
    }
}
