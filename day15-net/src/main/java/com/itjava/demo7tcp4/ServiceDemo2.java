package com.itjava.demo7tcp4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServiceDemo2 {
    public static void main(String[] args) throws Exception {
        //目标：BS架构的原理理解
        //1.创建服务端ServiceSocket对象，绑定端口号
        ServerSocket ss = new ServerSocket(8080);

        //
        while (true) {
            // 2、调用accept方法，阻塞等待客户端连接，一旦有客户端链接会返回一个Socket对象
            Socket socket = ss.accept();
            //3.把这个客户端管道交给一个独立的线程去处理这个管道的信息
            //把这些客户端管道包装成一个任务交给线程池处理
            ExecutorService pool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
            pool.execute(new ServiceReader(socket));
        }

    }
}
