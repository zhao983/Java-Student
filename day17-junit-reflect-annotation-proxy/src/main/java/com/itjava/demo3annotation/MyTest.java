package com.itjava.demo3annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  //一直保留到运行阶段。
@Target({ElementType.FIELD,ElementType.METHOD})  //声明后这个注解只能使用成员变量(局部变量不行(main方法或其他方法不行))和方法
public @interface MyTest {
}

/*
@Target : 声明注解可以被使用在哪些位置
TYPE, 类, 接口
IELD, 成员变量
METHOD, 成员方法
PARAMETER, 方法参数
CONSTRUCTOR, 构造器
LOCAL_VARIABLE, 局部变量
*/
/*
@Retention
作用：声明注解的保留周期。
@Retention(RetentionPolicy.RUNTIME)
SOURCE
● 只作用在源码阶段，字节码文件中不存在。
CLASS（默认值）
● 保留到字节码文件阶段，运行阶段不存在。
RUNTIME（开发常用）
● 一直保留到运行阶段。
*/