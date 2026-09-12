package com.javademo.demo;

public class GoldCard extends Card {

    //在子类中创建构造器把参数传给父类  super()方法
    public GoldCard(String name, String phoneNumber, double money) {
        super(name, phoneNumber, money);
    }

    //如果是金卡，则消费打八折
    //所以与父类的直接消费不同，重写consumeMoney()方法

    @Override
    //这里面的形参double money是消费的金额
    public void consumeMoney(double money) {

        //调用静态方法的时候要在前面加上类名.  /SilverCardUtil.
        if(!SilverCardUtil.balanceIsEnough(getMoney(),money)){
            return;
        }
        System.out.println("尊贵的金卡用户，你好");
        System.out.printf("您本次实际消费金额为:%.2f", money * 0.8);//消费金额，用形参，不加this
        System.out.println();
        setMoney(getMoney() - money * 0.8);
        System.out.println("您的余额为:" + getMoney());

    }
}
