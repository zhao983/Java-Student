package com.itjava.innerclass;

public class Outer {
    private static String name = "张三";

    //当认为没必要再在外部创建一个类的时候，就可以把类创建在内部
    public class Inner {
        //成员内部类属于对象持有
        //正常类中所具有的内部类都可以有，如成员变量，方法，构造器等
        private String name;

        public void show() {
            System.out.println("内部类的show方法");
            //成员内部类可以直接访问外部类的静态成员变量
            System.out.println(name);
//          System.out.println(Outer.name);  //或者这样写
        }

        public Inner() {
        }

        public Inner(String name) {
            this.name = name;
        }
    }
}
