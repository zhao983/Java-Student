package com.itjava.demo1exception;

/*
 * 自定义运行时异常
 * 1.继承父类RuntimeException
 * 2.重写父类Exception的构造器
 * */
public class ExceptionDemo4 {
    public static void main(String[] args) {
        System.out.println("程序开始");
        saveAge(200);  //不报错
        // 自定义运行时异常不会一直提醒，不需要每次写时都注意，真出错了也会进行提醒。
        //所以现在更多用运行时异常，要不然一直往上抛或者写代码的时候会很麻烦
        /*
        try {
            saveAge(300);
        } catch (AgeRuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
        */
    }

//    public static void saveAge(int age) throws AgeRuntimeException {  //throws AgeRuntimeException默认会加上去
    public static void saveAge(int age)  {
        if (age > 200 || age < 0) {
            throw new AgeRuntimeException("年龄输入不合法");
        } else {
            System.out.println("年龄保存成功:" + age);
        }
    }

}
