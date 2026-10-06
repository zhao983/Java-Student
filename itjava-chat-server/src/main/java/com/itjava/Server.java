package com.itjava;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    //定义一个Map集合(因为要包含管道和对应的用户)来存放所有的管道，以便后续向所有管道中推送消息
    //用管道来当键，用户名当值(名字可能有重复)
    //onLineSocket 加了 final 以后，禁止的是让 onLineSockets 改去指向另一个 Map。
//    public static final Map<Socket,String> onLineSocket = new HashMap<>();
    /*HashMap 的迭代器属于一种 fail-fast（快速失败） 机制。你可以把它理解成：开始遍历的时候，迭代器会大致记住“这个集合目前是什么状态”；如果遍历过程中发现集合的结构被别人改了，比如新增或删除元素，它会认为：
            “我现在遍历的集合已经和刚开始时不一样了，我没法保证继续遍历是安全的。”

    于是就直接抛：
    ConcurrentModificationException*/

    public static final Map<Socket, String> onLineSocket = new ConcurrentHashMap<>();
    /*ConcurrentHashMap

    以后，原因不是“它永远不允许别人修改”，恰恰相反，它就是为了：
    允许多个线程同时安全地读写。

    它的迭代器不像 HashMap 那样要求“遍历期间集合绝对不能改”。*/

    public static void main(String[] args) {
        System.out.println("启动服务端");
        //1.注册端口
        try {
            ServerSocket serverSocket=new ServerSocket(Constant.PORT);
            //2.主线程负责接受客户端请求
            while (true){
                System.out.println("等待客户端连接");
                //3.通过accept方法获取客户端的Socket对象
                Socket socket = serverSocket.accept();
                //4.把这个管道交给一个独立的线程以便多个客户端可以同时来通信
                new ServiceReader(socket).start();

                System.out.println("一个客户端连接成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
