package com.javademo.extends6constructor;

public class People {
    private String name;
    private int age;
    private String sex;

    public People(String name, String sex) {
//        this.sex = sex;
//        this.age=18;
//        this.name = name;
        //这样可以直接调用兄弟构造器，
        this(name, 18, sex);
        //super(),this()都必须写在构造器第一行
        //super(),this()不能同时出现,因为this在调用兄弟构造器后兄弟构造器会调用父类构造器,同时出现会导致调用两次父类构造器
    }

    public People(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public People() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
