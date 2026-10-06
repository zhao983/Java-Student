package com.itjava.demo2udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServiceDemo2 {
    public static void main(String[] args) throws Exception {
        //目标：完成UDP通讯一发一收，服务端开发
        //1.创建接收端对象，注册端口
        DatagramSocket socket = new DatagramSocket(8080);
        //2.创建数据包对象负责接受的数据
        byte[] buffers = new byte[1024 * 64];  //客户端最大一次传输64KB
        //两个参数                                  要发送的数据 数据长度
        DatagramPacket packet = new DatagramPacket(buffers, buffers.length);

        //3.让接受端对象接受数据包数据
        socket.receive(packet);

        //4.显示数据是否接收到
        //获取收到的数据长度
        int len = packet.getLength();      //  应该是从0开始，别忘了0
        String str = new String(buffers, 0, len);
        System.out.println("这里是服务端，接收到数据：" + str);

        //获得对方IP和端口   getAddress()：这个方法返回一个 InetAddress 对象。  .getHostAddress()：将 InetAddress 对象转换成人类可读的字符串格式
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        System.out.println("对方IP：" + ip + "\t" + "对方端口号为:" + port);

        //接受完后关闭资源
        socket.close();

    }
}
