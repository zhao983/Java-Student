package com.itjava.demo3annotation;

@MyTest2(name = "张三",address = {"北京","上海"})
public class Demo {

    @MyTest2(name = "李四",address = {"北京","上海"})
    public void go() {

    }

}
