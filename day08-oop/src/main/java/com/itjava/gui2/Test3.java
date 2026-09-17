package com.itjava.gui2;

public class Test3 {
    public static void main(String[] args) {
        //目标：定义一个登录页面，让页面本身也是事件监听器对象
        //创建一个登录页面的类,再让这个类创建对象
        LoginJFrame loginJFrame = new LoginJFrame();
        loginJFrame.init();
        loginJFrame.setVisible(true);
    }
}
