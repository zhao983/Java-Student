package com.itjava.interface2;

//接口的好处
public class Test {
    People s = new Student();
    //弥补了类单继承的不足，一个类同时可以实现多个接口，使类的角色更多，功能更强大。
    Drive d = new Student();
    BoyFriend bf = new Student();

    //让程序可以面向接口编程，这样程序员就可以灵活方便的切换各种业务实现（更利于程序的解耦合）
    Drive dt = new Teacher();
}

class People {
}

interface Drive {
}

interface BoyFriend {
}

class Student extends People implements Drive, BoyFriend {

}

class Teacher extends People implements Drive{

}
