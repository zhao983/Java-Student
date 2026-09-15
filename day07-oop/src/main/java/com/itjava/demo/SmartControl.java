package com.itjava.demo;

public class SmartControl {
    private static final SmartControl smartControl = new SmartControl();
    private SmartControl(){

    }
    //单例类的第三步，创建一个返回该对象的方法
    public static SmartControl getInstance(){
        return smartControl;
    }
    public static void control(JD jd){
        jd.press();
    }

    public static void printAllStatus(JD[] jd) {
        for(int i=0;i<jd.length;i++){
            System.out.println((i+1)+"."+jd[i].getName() + ":\t" + (jd[i].isStatus() ? "开" : "关"));
        }
    }





}
