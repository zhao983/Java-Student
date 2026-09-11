package com.javademo.javabean;

//业务类
public class StudentService {
    Student st;
    //这只是声明了一个 Student 类型的引用变量 s，此时它还没有指向任何 Student 对象，默认值是：null
    /*它不是在说：创建一个学生。
    而是在说：我准备了一个变量，以后可以让它指向某个 Student 对象。*/
    //引用变量和对象不是同一个东西。


    public StudentService() {
    }
    //设置一个有参构造器把st传过来
    public StudentService(Student st){
        this.st=st;
    }

    //然后对他执行操作
    public void printName(){
        System.out.println(st.getName());
    }

    public void printAge(){
        System.out.println(st.getAge());
    }

}
