package com.itjava.demo1exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        //认识异常的作用
        System.out.println("程序执行开始");
        try {
            System.out.println(div(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //这样程序不会被杀死
        System.out.println("程序执行结束");
    }

    public static int div (int a,int b) throws Exception {
        if (b == 0){
            throw new Exception("除数不能为0");  //可以作为方法的特殊返回值，以便通知上层调用者方法执行的问题
        }

        return a/b;
    }
}
