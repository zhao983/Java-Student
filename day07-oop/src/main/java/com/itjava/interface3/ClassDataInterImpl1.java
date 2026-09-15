package com.itjava.interface3;

public class ClassDataInterImpl1 implements ClassDataInter{
    //接口的实现类要记住对象的信息
    private Student[] stu;

    public ClassDataInterImpl1(Student[] stu) {
        this.stu = stu;
    }

    @Override
    public void printStudent() {
        for (int i=0;i<stu.length;i++){
            //别忘了stu后面的[i]
            System.out.println(stu[i].getName()+"\t"+stu[i].getSex()+"\t"+stu[i].getScore());
        }
    }

    @Override
    public void printAverage() {
        double sum = stu[0].getScore();
        for (int i = 1;i<stu.length;i++){
            sum += stu[i].getScore();
        }
        System.out.println("平均分为:"+sum/stu.length);
    }
}
