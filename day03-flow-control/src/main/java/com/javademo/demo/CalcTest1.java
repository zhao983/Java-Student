package com.javademo.demo;

import java.util.Scanner;
/*System.out.printf("姓名：%s，年龄：%d%n", name, age);
%s      字符串
%d      整数
%f      小数
%n      换行*/

public class CalcTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入第一个数字：");
            double a = sc.nextDouble();
            System.out.println("请输入运算符：");
            String b = sc.next();
            System.out.println("请输入第二个数字：");
            double c = sc.nextDouble();
            if (b.equals("+") || b.equals("-") || b.equals("*") || b.equals("/")){
                //字符串类型的等比应该用eauals();
                System.out.println(a+b+c+"="+test(a, b, c));
                break;
            }else {
                System.out.println("输入格式错误，请重新输入");
            }
        }

    }


    //简易运算器
    public static double test(double a,String b,double c){
        Scanner sc = new Scanner(System.in);
        switch (b){
            case "+":
                return a+c;
                //break;因为上面有return了，所以不需要break了
            case "-":
                return a-c;
               // break;因为上面有return了，所以不需要break了
            case "*":
                return a*c;
                //break;因为上面有return了，所以不需要break了
            case "/":
                return a/c;
                //break;因为上面有return了，所以不需要break了
            default:
                return 0;
                //break;
        }


    }
}
