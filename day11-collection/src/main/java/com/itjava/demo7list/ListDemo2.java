package com.itjava.demo7list;

import java.util.LinkedList;

public class ListDemo2 {
    public static void main(String[] args) {
        // 目标：用LinkedList做一个队列对象。  增删多查询少用LinkedList
        //LinkedList对首尾的操作很快，所以有很多对首位数据进行操作的独有功能
        // addFirst() addLast()
        //removeFirst() removeLast()
        //getFirst()  getLast()
        LinkedList<String> queue = new LinkedList<>();
        // 入队
        queue.addLast("赵敏");
        queue.addLast("西门吹雪");
        queue.addLast("陆小凤");
        queue.addLast( "石观音");   //默认就是addLast，以保证加数据都要加到最后面
        System.out.println(queue); // [赵敏, 西门吹雪, 陆小凤, 石观音]

        // 出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        // 做一个栈
        LinkedList<String> stack = new LinkedList<>();
// 压栈
        stack.addFirst("第1颗子弹");
        stack.push("第2颗子弹");  //push就是调用了addFirst方法来实现的
        stack.push("第3颗子弹");
        stack.push("第4颗子弹");
        System.out.println(stack); // [第4颗子弹, 第3颗子弹, 第2颗子弹, 第1颗子弹]

// 出栈
        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());  //pop时调用了removeFirst方法实现的
        System.out.println(stack);
    }
}
