package com.itjava.singleinstance;

//认识单例类
//单例类作用：确保类只能够创建一个对象，像任务管理器，不管打开多少次都只有一个窗口
//好处：避免浪费内存
public class Test {
    public static void main(String[] args) {
/*
        //当public static A a = new A();
        A a1 = A.a;
        A a2 = A.a;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1 == a2);
        //输出一样的地址
        //singleinstance.A@2f4d3709
        //singleinstance.A@2f4d3709
        //true
        A.a=null;
        System.out.println(A.a);  //输出null
*/

        A a1 = A.getObject();
        A a2 = A.getObject();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1 == a2);

        System.out.println("-------------");

        B b1 = B.bObiect();
        B b2 = B.bObiect();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);


/*

        C c;
        C c1=new C();
        c=c1;
        System.out.println(c);
        System.out.println(c1);
        地址一样
*/

    }
}

/*

class C{
}

*/

