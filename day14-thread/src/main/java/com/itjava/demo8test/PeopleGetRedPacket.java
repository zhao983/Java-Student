package com.itjava.demo8test;

import java.util.List;

public class PeopleGetRedPacket extends Thread {
    private int id;
    private List<Double> redPacket;  //创建一个红包集合指向200个红包


    @Override
    public void run() {
        while (true) {  //一个人可以重复抢红包
            //当有人点到时对红包上锁，所以锁的对象选红包redPacket
            synchronized (redPacket) {

                //竞争到锁后检查红包数量,当红包抢完时，结束循环
                if (redPacket.size() == 0) {
                    break;
                }

                //随机一个索引值为本次抢到的红包
                int index = (int) (Math.random() * redPacket.size());
                System.out.println("员工" + id + "抢到" + redPacket.get(index) + "元");
                //移除抢到的红包
                redPacket.remove(index);
                if (redPacket.size() == 0) {
                    System.out.println("活动结束");
                    break;
                }


            }
            //设置一个反应时间，否则一个线程可以抢完所有的红包  应在抢完之后sleep
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public PeopleGetRedPacket(int id, List<Double> redPacket) {
        this.id = id;
        this.redPacket = redPacket;
    }
}
