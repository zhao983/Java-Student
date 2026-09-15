package com.itjava.interface4;

public class Test {
    public static void main(String[] args) {
        AImpl a = new AImpl();
        a.go();

        System.out.println("----------");
        A.work();
    }
}

class AImpl implements A {

}