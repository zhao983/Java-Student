package com.javademo.object;

public class Test2 {
    public static void main(String[] args) {
        Students st1 = new Students();
        st1.name = "张三";
        st1.chinese = 68;
        st1.math = 88;
        st1.printSumScore();
        st1.printAverage();
    }
}
