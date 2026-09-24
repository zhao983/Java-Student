package com.itjava.demo4genericity;


public class GenericDemo4 {
    public static void main(String[] args) {
        //认识泛型方法
        //需求：打印任意数组的内容
        String[] names ={"张三","李四","王五"};
        Student[] numbers = new Student[3];
        numbers[0] = new Student(1);
        numbers[1]=new Student(2);
        numbers[2]=new Student(3);
        print(names);
        print(numbers);
    }
    //泛型方法：在返回值前面加上泛型
    public static <T> void print(T[] t){
        for(int i = 0; i<t.length;i++){
            System.out.println(t[i]);
        }
    }
    //如果返回值和泛型相同，可以直接把返回值也写成泛型
    public static <T> T getMax(T[] t){
        return null;
    }
}
