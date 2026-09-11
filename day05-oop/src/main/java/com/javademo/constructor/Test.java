package com.javademo.constructor;

public class Test {
    public static void main(String[] args) {
        //构造器特点，创建对象后，对象会立即调用构造器
        Student st1 = new Student();
        Student st2 =new Student("有参构造器");
        st1.name="李二";
        st1.age=18;
        st1.printName();
        st1.printAge();
        System.out.println("--------------------");
        //构造器可以方便传参数
        Student st3 =new Student("张三",18);
        st3.printName();
        st3.printAge();

    }


}
