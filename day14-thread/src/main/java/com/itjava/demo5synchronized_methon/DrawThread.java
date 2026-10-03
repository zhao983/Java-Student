package com.itjava.demo5synchronized_methon;

public class DrawThread extends Thread {
    private Account acc;

    public DrawThread() {

    }

    public DrawThread(String name, Account acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(10000);
    }
}
