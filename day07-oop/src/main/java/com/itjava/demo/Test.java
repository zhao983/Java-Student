package com.itjava.demo;

import java.util.Scanner;

//某智能家居系统，可以让用户选择要控制的家用设备（吊灯，电视机，洗衣机），并可以对它们进行打开或者关闭操作。
public class Test {
    public static void main(String[] args) {
        //第一步，先创建这些家电的类，所有家电都有名字和状态（开/关）两种状态，所以先定义一个父类
        //之后创建对应的子类继承这个JD父类
        //然后就可以用父类先定义一个对象数组，然后分别创建对应的对象(多态)
        JD[] jds = new JD[3];
        jds[0] = new TV("电视", false);
        //创建子类的构造器，方便创建对象的时候直接赋值
        jds[1] = new Lamp("灯", true);
        jds[2] = new WashMachine("洗衣机", false);

        //之后我们系统一定要有的功能：控制开关
        //所以可以设计一个接口，来放入这个功能的方法   创建了接口 Switch
        //再让父类JD去实现这个接口，这样子类就都能调用这个接口中的功能

        //再创建一个智能控制系统对象，需要完成的功能：1.来打印设备的状态，2.并控制系统的开和关(什么时候调用接口的方法）
        //定义智能控制系统SmartContorl
        //因为只用得到一个对象，所以可以设计成单例类
        Scanner sc =new Scanner(System.in);
        String command = "";
        while (true){
            SmartControl.printAllStatus(jds);
            System.out.println("请输入您要操作的对象,输入'exit'时退出");
            command=sc.next();
            switch (command){
                case "1":
                    SmartControl.control(jds[0]);
                    break;
                case "2":
                    SmartControl.control(jds[1]);
                    break;
                case "3":
                    SmartControl.control(jds[2]);
                    break;
                case "4":
                    SmartControl.control(jds[3]);
                    break;
                case "exit":
                    System.out.println("已退出该系统");
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");

            }

            }

    }


}
