package com.itjava.demo6tcp3;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo1 {
    //目标：实现TCP协议下的多发多收 客户端开发  支持多个客户端开发
    public static void main(String[] args) throws Exception {
        //1.常见的Socket管道对象，请求与服务端Socket连接 可靠连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.从socket字节管道中得到一个输出流
        OutputStream os = socket.getOutputStream();
        //3.特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        int i = 0;
        //在这里加上死循环
        while (true) {
            System.out.println("请说:");
            String str = sc.nextLine();
            if(str.equals("exit")){
                //关闭资源
                socket.close();
                break;
            }
            i++;
            dos.writeInt(i);
            dos.writeUTF(str);

            //刷新
            dos.flush();
        }

    }
}
