package com.javademo.extends3demo;

//方法重写的常见场景：在子类中重写toString方法
public class Test {
    public static void main(String[] args) {
        A a =new A("张三",18);
        System.out.println(a);//直接写a会默认调用Object中的toString方法，输出a的地址

    }
}

//public class A{ } 报错
//一个 .java 文件里，最多只能有一个 public 顶级类，而且文件名必须和这个 public 类名一致。

class A{
    private String name ;
    private int age;

    //所以可以对toString方法进行重写，让他输出a的信息
    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public A() {}

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
