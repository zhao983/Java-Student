package com.javademo.operator;

import java.util.Scanner;

public class OperatorDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        operatorPrint(a,b);
        operatorAdd();

        //自增自减用法
        int c = a++;//先赋值再加
        System.out.println(a+" "+c);
        int d = ++a;//先加再复制
        System.out.println(a+" "+d);
    }

    public static void operatorPrint(int a, int b){
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a%b);//取余数
        System.out.println(a/b);//看最大类型，这里面最大为int默认取整
        System.out.println((double)a/b);//可以转换类型
        System.out.println(1.0*a/b);//1.0为double类型
    }

    //+可以做连接也可以做运算。规则是能算就算，不能就连接
    public static void operatorAdd(){
        int a = 5;
        System.out.println("abc"+a);
        System.out.println("abc"+a+'a');//abc5a：abc+a不能算，连接完后的abc5与a不能算
        System.out.println(a+'a'+"abc");//102abc：a+字符a可以算，为102.102与abc不能算



    }

}
