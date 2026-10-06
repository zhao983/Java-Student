package com.itjava.demo1inetaddress;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) {
        //目标：认识InetAddress获取本机IP对象和对方IP对象
        try {
            //获取本机IP对象
            InetAddress ip1 = InetAddress.getLocalHost(); //获取本机IP地址
            System.out.println(ip1.getHostName());  //得到IP主机名
            System.out.println(ip1.getHostAddress()); //得到IP信息

            //获取对方IP对象
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip2.getHostName());
            System.out.println(ip2.getHostAddress());

            //判断本机与对方是否能连同             设置最长尝试连接时间
            System.out.println(ip2.isReachable(5000));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
