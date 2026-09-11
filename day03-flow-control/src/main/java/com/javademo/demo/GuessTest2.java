package com.javademo.demo;

import java.util.Random;
import java.util.Scanner;

public class GuessTest2 {
    public static void main(String[] args) {
        test();

    }

    //猜数字，先生成一个随机数，如何输入数字大了小了都进行提醒，相等后退出
    public static void test(){
        Random random = new Random();//生成随机数
        //法2：
        //int num = (int)Math.random()  生成一个0到1的小数（因为是小数，不会为1）
        int a = random.nextInt(1,101);//遵循：[起始值, 结束值)
        System.out.println(a);

        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("请猜测1到100间的数字：");
        while (true){
            count = sc.nextInt();
            if(count>a){
                System.out.println("大了，请重新猜测：");
            } else if (count<a) {
                System.out.println("小了，请重新猜测：");
            } else {
                System.out.println("恭喜你，猜对了！");
                break;
            }
        }
    }
}
