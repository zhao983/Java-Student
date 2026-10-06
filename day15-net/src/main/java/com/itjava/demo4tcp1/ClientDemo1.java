package com.itjava.demo4tcp1;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo1 {
    //目标：实现TCP协议下的一发一收 客户端开发
    public static void main(String[] args) throws Exception {
        //1.常见的Socket管道对象，请求与服务端Socket连接 可靠连接
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        //2.从socket字节管道中得到一个输出流
        OutputStream os = socket.getOutputStream();

        //3.特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
        dos.writeUTF("这里是客户端");

    }
}
