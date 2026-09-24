package com.itjava.demo1exception;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    //认识异常的体系，搞清楚异常的基本作用
//    public static void main(String[] args) throws ParseException {   可以接着往外抛
    public static void main(String[] args) {
//        show();

        try {  //解决方法二：监视代码，出现异常会被catch拦截
            show2();
        } catch (ParseException e) {
            e.printStackTrace();  //打印异常信息   未报告的异常错误java.text.ParseException; 必须对其进行捕获或声明以便抛出
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } //catch(Exception e){  //所有异常用相同的方法处理
           // e.printStackTrace();
        //}
    }

    //定义一个方法认识编译时异常             Exception代表抛出所有异常
//    public static void show2() throws Exception {
    public static void show2() throws ParseException, FileNotFoundException {  //解决方法一：抛出异常，把异常往外抛
        System.out.println("程序开始");
        //编译时异常，编译阶段报错，编译不通过
        String str = "2025-09-08 11:25:15";
        //把字符串中的事件解析为Java中的一个简单的日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //上下格式必须一样
        //解析 parse() 将String字符串转换为Date对象  格式化 format() 将Date对象格式化为String字符串
        Date date = sdf.parse(str);  //编译时异常，提醒程序员这里的程序很容易出错，请注意
        System.out.println(date);

//        InputStream is = new FileInputStream("D:/oi.png");  //可能会没有D盘，所以也会出异常

        System.out.println("程序结束");

    }

    //定义一个方法展示运行时异常
    public static void show(){
        System.out.println("程序开始");
        //运行时异常特点：编译阶段不报错，运行时出现异常所有的运行时异常都继承自RuntimeException
//        int[] arr = {1,2,3};
//        System.out.println(arr[3]);  //ArrayIndexOutOfBoundsException  索引越界异常

//        System.out.println(10/0);  //ArithmeticException  数字操作异常

//        String str = null;
//        System.out.println(str.length());  //NullPointerException 空指针异常
        //异常出现后程序挂掉不会再执行
        System.out.println("程序结束");
    }
}
