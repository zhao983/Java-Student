package com.itjava.demo4genericity;

import java.util.ArrayList;

public class GenericDemo5 {
    public static void main(String[] args) {
        //目标：认识通配符和他的上下限
        ArrayList<XiaoMi> xiaoMis = new ArrayList<>();
        xiaoMis.add(new XiaoMi());
        xiaoMis.add(new XiaoMi());
        go(xiaoMis);

        ArrayList<BYD> byds = new ArrayList<>();
        byds.add(new BYD());
        byds.add(new BYD());
        go(byds);

//        ArrayList<Dog> dogs = new ArrayList<>();
//        dogs.add(new Dog());
//        dogs.add(new Dog());
//        go(dogs);
    }

    //通配符就是“?”，可以在“使用泛型”的时候代表一切类型；ETKV是在定义泛型的时候使用(如定义泛型类，泛型方法等)。
    //需求：开发一个飞车游戏
    // 虽然Xiaomi和BYD是Car的子类，但是 ArrayList<Xiaomi>  ArrayList<BYD>和 ArrayList<Car> 是没有半毛钱关系！
//    public static void go(ArrayList<?> cars){
    //泛型上下限
    // 泛型上限： ? extends Car： ? 能接收的必须是Car或者其子类。
    //泛型下限： ? super Car : ? 能接收的必须是Car或者其父类。
    public static void go(ArrayList<? extends Car> cars){

    }
}
