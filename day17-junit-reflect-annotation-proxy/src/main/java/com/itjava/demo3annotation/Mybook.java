package com.itjava.demo3annotation;

//自定义注解
public @interface Mybook {
    String name();
    int age() default 18; // default : 默认值
    String[] address();

}
