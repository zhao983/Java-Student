package com.javademo.polymorphsm2;

public class Tortoise extends Animal {

    private String name="乌龟";

    @Override
    public void run() {
        System.out.println("乌龟跑的慢");
    }

    public void lifeLong(){
        System.out.println("活得久");
    }


}
