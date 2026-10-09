package com.itjava.demo2reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        // 目标：反射的基本作用。
        // 1、类的全部成分的获取
        // 2、可以破坏封装性
        // 3、可以绕过泛型的约束。
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
//        list.add(1);   //报错

        Class c1 = list.getClass();  //c1 == ArrayList.class
        //获取ArrayList 类的add方法
        Method method = c1.getDeclaredMethod("add",Object.class);
        //触发List集合对象的add方法
        method.invoke(list,1);
        method.invoke(list,true);
        System.out.println(list);

    }
}
