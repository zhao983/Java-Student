package com.itjava.interface3;

public class ClassDataInterImpl2 implements ClassDataInter{
    //接口的实现类要记住对象的信息
    Student[] stu;

    public ClassDataInterImpl2(Student[] stu) {
        this.stu = stu;
    }

    @Override
    public void printStudent() {
        int boycount = 0;
        for(int i=0;i<stu.length;i++){
            if("男".equals(stu[i].getSex()))
                boycount++;
            System.out.println(stu[i].getName()+"\t"+stu[i].getSex()+"\t"+stu[i].getScore());
        }
        System.out.println("全班男生为："+boycount);
        System.out.println("全班女生为："+(stu.length-boycount));
    }

    @Override
    public void printAverage() {
        double max = stu[0].getScore();
        double min = stu[0].getScore();
        double sum = stu[0].getScore();
        //这里不能定义min=0；因为如果最后比较完后，没有小于等于0的，最后减的会是0，所以用stu里面存的数据
        for (int i = 1;i<stu.length;i++){
            sum += stu[i].getScore();
            if(max<stu[i].getScore()){
                max=stu[i].getScore();
            }
            if(min>stu[i].getScore()){
                min=stu[i].getScore();
            }
        }
        System.out.println("最高分为:"+max);
        System.out.println("最低分为:"+min);
        System.out.println("去掉最高分和最低分后的平均分为:"+((sum-max-min)/(stu.length-2)));

    }
}
