package com.itjava.innerclass;

public class InnerClassDemo1 {
    //认识成员内部类
    public static void main(String[] args) {
        //成员内部类创建对象的格式
        //外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
        Outer.Inner oi = new Outer().new Inner();
        //调用方法就正常调用  对象名.方法名
        oi.show();

        //成员内部类访问外部类成员的特点
        //1.成员内部类可以直接访问外部类的静态成员变量
        //2.成员内部类的实例方法中，可以直接拿到寄生的外部类对象  外部类名.this
        People.Heart ph = new People().new Heart();
        ph.show();
    }

}

class People {
    int heart = 100;

    public class Heart {
        int heart = 200;

        public void show() {
            int heart = 80;
            System.out.println(heart);  //局部变量
            System.out.println(this.heart);  //内部类
            System.out.println(People.this.heart);  //外部类
            //输出
//            80
//            200
//            100
        }
    }
}
