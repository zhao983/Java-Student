package com.javademo.demo;

public class SilverCard extends Card {

    //在子类中创建构造器把参数传给父类  super()方法
    public SilverCard(String name, String phoneNumber, double money) {
        super(name, phoneNumber, money);
    }

    //如果是银卡，则消费打九折
    @Override
    //这里面的形参double money是消费的金额
    public void consumeMoney(double money) {

        if(!SilverCardUtil.balanceIsEnough(getMoney(),money)){
            return;
        }

        System.out.println("尊贵的银卡用户，你好");
        System.out.printf("您本次实际消费金额为:%.2f", money * 0.9);//消费金额，用形参，不加this
        System.out.println();
        setMoney(getMoney() - money * 0.9);
        System.out.println("您的余额为:" + getMoney());

    }

}
