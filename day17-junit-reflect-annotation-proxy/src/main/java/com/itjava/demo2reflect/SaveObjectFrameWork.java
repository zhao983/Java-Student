package com.itjava.demo2reflect;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrameWork {
    //保存容易的静态方法
    public static void saveObject(Object obj) throws Exception {
        //obj可能是学生,老师
        //只有反射可以知道对象有多少个字段
        PrintStream printStream = new PrintStream(new FileOutputStream("day17-junit-reflect-annotation-proxy/src/main/java/com/itjava/demo2reflect/1.txt", true));
        //1.获取Class对象
        Class c1 = obj.getClass();
        String str = c1.getSimpleName();
        printStream.println("===========" + str + "============");
        //2.获得Class的所有字段
        Field[] fields = c1.getDeclaredFields();
        ;

        //3.遍历
        for (Field field : fields) {
            //撬开权限
            field.setAccessible(true);
            //获取字段名称
            String fieldName = field.getName();
            //获取字段值
            String fieldValue = field.get(obj) + "";
            printStream.println(fieldName + "=" + fieldValue);
        }

        //关闭流
        printStream.close();
    }
}
