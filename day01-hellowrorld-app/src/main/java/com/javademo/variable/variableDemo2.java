package com.javademo.variable;

import static com.javademo.variable.variableDemo1.PrintVariable;//导入其他文件函数

public class variableDemo2 {
    public static void main(String[] args) {
        PrintVariable2();
        PrintVariable();
    }
    public static void PrintVariable2(){
        byte a = 1;
        System.out.println(a);
        //byte a1=128 过界报错
        long b = 1345243561543L;
        System.out.println(b);
        //默认是int类型，用long超出int界限后要在数字末尾加L/l

        float c = 2.2f;
        System.out.println(c);
        //默认是double类型，用float后要在数字末尾加f
        double d = 2.6;
        System.out.println(d);

        char e = 'a';
        System.out.println(e);

        String f = "String";
        System.out.println(f);

        System.out.println("---------------------------");
        System.out.println(""+a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f);




    }
}
