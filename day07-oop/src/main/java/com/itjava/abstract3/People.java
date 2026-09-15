package com.itjava.abstract3;

public abstract class People {
    public void write(){
        System.out.println("\t\t《我的学校》");
        System.out.println("让我来给你们介绍一下我的学校");
        writeSchool();
        System.out.println("这就是我的学校");
    }

    public abstract void writeSchool();
}
