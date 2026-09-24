package com.itjava.demo1exception;

/*
 * 自定义编译时异常
 * 1.继承父类Exception
 * 2.重写父类Exception的构造器
 * */
public class ExceptionDemo3 {
    public static void main(String[] args) {
        System.out.println("程序开始");
//        saveAge(200);  //报错 自定义编译时异常可以提醒写代码时的容易出现的问题，还可以帮忙定位问题
        try {
            saveAge(300);
        } catch (AgeException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }

    public static void saveAge(int age) throws AgeException {
        if (age > 200 || age < 0) {
            throw new AgeException("年龄输入不合法");
        } else {
            System.out.println("年龄保存成功:" + age);
        }
    }

}
