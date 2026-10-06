package com.itjava.demo3udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：完成UDP通讯多发多收，客户端开发
        //1.创建发送端对象
        DatagramSocket socket = new DatagramSocket();  //随机端口
        Scanner sc = new Scanner(System.in);
        //把发送数据放到一个死循环中
        while (true) {
            System.out.println("请输入:");
            String str = sc.nextLine();
            byte[] bytes = str.getBytes();
            if(str.equals("exit")){
                socket.close();
                break;
            }
            //2.创建数据包对象封装要发送的数据
            //四个参数                                  要发送的数据 数据长度     对方IP                   服务端程序端口号
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8080);

            //3.让发送端对象发送数据包数据
            socket.send(packet);
        }

    }
}

/*
1. 与 nextInt() 等方法混用时的换行符残留（最常见）
nextInt()、nextDouble()、next() 等方法在读取完一个 token 后，不会消耗掉行尾的换行符。因此下一次调用 nextLine() 时，它会立刻读到这个残留的换行符，并返回一个空字符串。

示例：

java
Scanner sc = new Scanner(System.in);
System.out.print("请输入年龄：");
int age = sc.nextInt();          // 输入 25 后按回车
System.out.print("请输入姓名：");
String name = sc.nextLine();     // 这里会直接返回空字符串，不会等待输入
System.out.println(age + " " + name);
输出：

text
请输入年龄：25
请输入姓名：25
姓名变成了空字符串。

解决方案：

在 nextInt() 后额外加一句 sc.nextLine(); 来消耗掉换行符：

java
int age = sc.nextInt();
sc.nextLine(); // 消耗换行符
String name = sc.nextLine();
或者全部用 nextLine() 读取，然后手动解析成数字：

java
int age = Integer.parseInt(sc.nextLine());
2. nextLine() 会读取整行，包括空格
nextLine() 返回的是从当前位置到行尾的所有字符（不含换行符），包括空格。而 next() 只读取到空格前的 token。

示例：

java
Scanner sc = new Scanner(System.in);
String s1 = sc.next();      // 输入 "hello world"
String s2 = sc.nextLine();  // s2 会得到 " world"（注意前面的空格）
3. 空行会返回空字符串，而不是 null
如果用户直接按回车，nextLine() 会返回 ""（长度为 0 的字符串），而不是 null。如果需要跳过空行，可以判断：

java
String line = sc.nextLine();
if (!line.isEmpty()) {
        // 处理非空行
        }*/
