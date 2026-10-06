package com.itjava.demo6tcp3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServiceReader extends Thread{
    private Socket socket;

    public ServiceReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //3.获取输入流
        InputStream is = null;
        try {
            is = socket.getInputStream();
            //4.把字节输入流包装成与客户端相同的数据流
            DataInputStream dis = new DataInputStream(is);

            //这里加上死循环
            while (true) {
                //5.读取数据
                int id = 0;
                id = dis.readInt();

                String msg = null;
                msg = dis.readUTF();

                System.out.println("id:" + id + "\t" + "msg:" + msg);

                //客户端IP和端口
                System.out.println("IP:"+socket.getInetAddress().getHostAddress()+"\t"+"端口:"+socket.getPort());

            }
        }catch (Exception e) {
            System.out.println("IP:"+socket.getInetAddress().getHostAddress()+"\t"+"端口:"+socket.getPort()+"下线了");


        }
    }
}
