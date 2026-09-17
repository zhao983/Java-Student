package com.itjava.lambda;

import com.itjava.innerclass3.Students;

import javax.swing.*;
import java.util.Arrays;

public class LambdaDemo2 {
    //目标：给数组排序，理解其中匿名内部类的用法
    public static void main(String[] args) {
        Students[] stu=new Students[4];
        stu[0]=new Students("张三",18);
        stu[1]=new Students("李四",25);
        stu[2]=new Students("王五",16);
        stu[3]=new Students("赵六",34);

        //需求：按年龄升序排序
        //可以直接调用sun公司的API
        //参数一：需要排序的参数，参数二：需要给sort声明一个Comparator比较器对象
/*
        Arrays.sort(stu, new Comparator<Students>() {  //通过重写Comparator接口里面的方法来定义比较的方法
            @Override
            public int compare(Students o1, Students o2) {
//                if(o1.getAge()> o2.getAge()){
//                    return 1;   //如果你认为  左边 大于 右边 返回正整数
//                } else if (o1.getAge()< o2.getAge()) {
//                    return -1;  //如果你认为  左边 小于 右边 返回负整数
//                }
//                return 0;       //如果你认为 右边 等于 右边 返回0
                //上面可以简化为
                return o1.getAge()-o2.getAge();  //年龄升序排列
//              return o2.getAge()-o1.getAge();  //年龄降序排列

            }
        });
*/
/*

        //上面可以接着简化
        Arrays.sort(stu, (Students o1, Students o2)->{
            return o1.getAge()-o2.getAge();
        });
*/

        //还可以简化
        //1.参数类型全部可以不写
        //2.如果只有一个参数，() 也可以不写  有多个则不能省略
        //3.如果Lambda表达式只有一行， 大括号可以不写，同时省略";",如果这行代码是return语句,也必须去掉return
        Arrays.sort(stu, (o1, o2)-> o1.getAge()-o2.getAge());

        for (int i=0;i<stu.length;i++){
            System.out.println(stu[i]);
        }


        System.out.println("----------------------");


        JFrame login =new JFrame("登录页面");  //窗口
        login.setSize(300,200);
        login.setLocationRelativeTo(null);  //居中显示
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口的同时关闭程序
        login.setVisible(true);

        JPanel panel = new JPanel(); //面板
        login.add(panel); //把面板加到窗口上

        JButton btn =new JButton("登录");  //按钮
        panel.add(btn);


        // 开发中不是我们要主动去写匿名内部类，而是用别人的功能的时候，别人可以让我们写一个匿名内部类

        //java要求必须给这个按钮添加一个点击事件监听器对象，这样就可以监听用户的点击操作，然后做出反应
    /*    btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("用户点击了按钮");
            }
        });   //这个是个接口
*/
      btn.addActionListener(e -> System.out.println("用户点击了按钮"));  //简化

        /*public interface ActionListener extends EventListener {

         *//**
         * Invoked when an action occurs.
         * @param e the event to be processed
         *//*
            public void actionPerformed(ActionEvent e);

        }*/
    }
}
