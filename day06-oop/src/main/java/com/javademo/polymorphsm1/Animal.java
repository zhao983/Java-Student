package com.javademo.polymorphsm1;

public class Animal {

    String name="动物";

    public void run(){
        System.out.println("动物在跑");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
