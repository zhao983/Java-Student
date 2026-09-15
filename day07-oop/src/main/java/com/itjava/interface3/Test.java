package com.itjava.interface3;

public class Test {
/*
    请设计一个班级学生的信息管理模块：学生的数据有：姓名、性别、成绩
    功能1：要求打印出全班学生的信息；功能2：要求打印出全班学生的平均成绩。

    注意！以上功能的业务实现是有多套方案的，比如：
    第1套方案：能打印出班级全部学生的信息；能打印班级全部学生的平均分。
    第2套方案：能打印出班级全部学生的信息（包含男女人数）；能打印班级全部学生的平均分（要求是去掉最高分、最低分）。
    要求：系统可以支持灵活的切换这些实现方案。
*/

    //先定义学生类
    public static void main(String[] args) {
        Student[] stu=new Student[5];
        stu[0]=new Student("张三","男",80);
        stu[1]=new Student("李四","男",90);
        stu[2]=new Student("王五","女",85);
        stu[3]=new Student("赵六","男",70);
        stu[4]=new Student("唐七","女",75);

        //定义接口，以方便后面功能的具体实现
        //任务：要求打印出全班学生的信息；功能2：要求打印出全班学生的平均成绩。
        //ClassDataInter cl = new ClassDataInterImpl1(stu);
        ClassDataInter cl = new ClassDataInterImpl2(stu);
        cl.printStudent();
        cl.printAverage();


    }


}
