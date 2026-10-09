package com.itjava.demo3annotation;

@Mybook(name = "张三", age = 18, address = {"北京", "上海"})
//@A(value = "delete")
@A("delete") //特殊属性,在使用时如果只有一个value属性,,则value名称可以不写

public class AnnotationDemo1 {
    public static void main(@A("delete") String[] args) {
        //目标:理解自定义注解
        @A("delete")
        int a;

    }
}
