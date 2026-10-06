package com.itjava.demo7tcp4;

import java.io.*;
import java.net.Socket;

public class ServiceReader extends Thread{
    private Socket socket;

    public ServiceReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            //给当前的浏览器管道响应一个网页数据回去
            OutputStream os = socket.getOutputStream();
            //通过字节输出包装写出去的数据给管道
            //把字节输出流包装成打印流 更方便 打印流能自动换行 HTTP协议要求换行
            PrintStream ps =new PrintStream(os);
            //写网页数据出去
            ps.println("HTTP/1.1 200 OK");  //HTTP协议第一行
            ps.println("Content-Type:text/html;charset=UTF-8");  //HTTP协议第二行 接下来1内容和格式
            ps.println();  //HTTP协议最后一行  一定要换行
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<title>");
            ps.println("JAVA学习网页测试");
            ps.println("</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1>JAVA学习网页测试</h1>");
            ps.println("</body>");
            ps.println("</html>");

            //请求完毕后可以关闭资源
            ps.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
