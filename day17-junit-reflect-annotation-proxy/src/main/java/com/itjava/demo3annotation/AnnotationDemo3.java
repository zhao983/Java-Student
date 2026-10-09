package com.itjava.demo3annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo3 {
    //目标:解析注解
    @Test
    public void parseClass(){
        //1.获取类对象
        Class c1 = Demo.class;
        //2.使用isAnnotationPresent判断这个类上是否陈列了注解MyTest2
        if(c1.isAnnotationPresent(MyTest2.class)){
            //3.获取注解对象
            MyTest2 a1 = (MyTest2) c1.getDeclaredAnnotation(MyTest2.class);
            //4.获取注解的属性值
            String name = a1.name();
            int age = a1.age();
            String[] addresses = a1.address();

            //5.打印注解的属性值
            System.out.println(name);
            System.out.println(age);
            System.out.println(Arrays.toString(addresses));
        }
    }

    @Test
    public void parseMethod() throws Exception {
        //1.获取类对象
        Class c1 = Demo.class;
        //2.获取类的方法对象
        Method m1= c1.getDeclaredMethod("go");
        //3.使用isAnnotationPresent判断这个方法上是否陈列了注解MyTest2
        if(m1.isAnnotationPresent(MyTest2.class)){
            //4.获取注解对象
            MyTest2 a1 = (MyTest2) m1.getDeclaredAnnotation(MyTest2.class);

            //5.获取注解属性值
            String name = a1.name();
            int age = a1.age();
            String[] addresses = a1.address();

            //6.打印注解的属性值
            System.out.println(name);
            System.out.println(age);
            System.out.println(Arrays.toString(addresses));

        }
    }
}
