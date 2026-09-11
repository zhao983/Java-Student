package com.javademo.branch;

import java.util.Scanner;

public class SwitchDemo1 {
    public static void main(String[] args) {
        sexSwitch();

    }

    public static void sexSwitch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入自己的性别：");
        String sex = sc.next();
        String b = "女";

        //switch不支持floa，double，long类型的数据
        switch (sex){
            case "男":
                System.out.println("男性");
                break;//一定要加这个break，不然程序会顺着一直往下执行，直到遇到break或执行完毕
                      //这种特性叫做switch的穿透性
            case "女":
                System.out.println("女性");
                break;
            //case的值不能重复
            /*case "女":
                System.out.println("女性");
                break;*/

            //case的值不能是变量
            /*case b:
                System.out.println("女性");
                break;*/
            default:
                System.out.println("多元性别");

        }

    }
}
