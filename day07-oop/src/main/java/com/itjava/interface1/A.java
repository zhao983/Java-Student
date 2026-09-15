package com.itjava.interface1;

public interface A {
    String NAME = "张三";
/*  上面等效于:
    public static final String name = "张三";
    public static final 会默认填写
  */
//    NAME = "李四"; //报错

    void go();
    //方法也会默认加上public abstract
}
