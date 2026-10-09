package com.itjava.demo2reflect;

public class Teacher {
    private String name;
    private String hobby;
    private String sex;

    private Teacher() {
        System.out.println("无参构造器被调用了");
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, String hobby) {
        System.out.println("有参构造器被调用了");
        this.name = name;
        this.hobby = hobby;
    }


    public Teacher(String sex, String name, String hobby) {
        this.sex = sex;
        this.name = name;
        this.hobby = hobby;
    }

    private void test(){
        System.out.println("无参方法执行了");
    }

    public String test(String name){
        System.out.println("有参方法执行了");
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
