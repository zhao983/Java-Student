package com.javademo.loop;

public class BreakContinueDemo4 {
    public static void main(String[] args) {
        test();

    }
    //break:跳出当前循环 continue：跳出本次循环
    public static void test(){
        for(int i = 0;i < 10;i++){
            if (i==5){
                break;
            }
            System.out.print(i+"\t");
        }
        System.out.println();

        for(int i = 0;i < 10;i++){
            if (i==5){
                continue;
            }
            System.out.print(i+"\t");
        }
    }
}
