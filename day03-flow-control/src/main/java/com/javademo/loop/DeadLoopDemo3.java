package com.javademo.loop;

import java.util.Scanner;

public class DeadLoopDemo3 {
    public static void main(String[] args) {
        deadLoop();
    }

    public static void deadLoop(){
        while (true){    //死循环因为不知道循环多少次，常用while
            Scanner sc = new Scanner(System.in);
            System.out.println("输入0结束死循环");
            int age = sc.nextInt();
            if (age == 0)
                break;
        }
    }
}
