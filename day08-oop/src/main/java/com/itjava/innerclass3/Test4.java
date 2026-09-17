package com.itjava.innerclass3;

import java.util.Arrays;
import java.util.Comparator;

public class Test4 {
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

        for (int i=0;i<stu.length;i++){
            System.out.println(stu[i]);
        }
    }
}
