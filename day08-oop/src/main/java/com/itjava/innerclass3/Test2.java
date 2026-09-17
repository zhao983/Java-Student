package com.itjava.innerclass3;

//匿名内部类使用场景：通常可以作为一个对象参数传送给方法使用
public class Test2 {
    //学生老师参加游泳比赛
    public static void main(String[] args) {
        Swim student = new Swim() {
            @Override
            public void swimming() {
                System.out.println("学生在游");
            }
        };

        start(student);

        System.out.println("------------");

        Swim teacher = new Swim() {
            @Override
            public void swimming() {
                System.out.println("老师在游");
            }
        };
        start(teacher);
    }

    //写具体的swim实现方法
    public static void start(Swim swim) {
        System.out.println("开始");
        swim.swimming();
        System.out.println("结束");
    }
}

//定义一个接口来放游泳的方法
interface Swim {
    void swimming();

}


