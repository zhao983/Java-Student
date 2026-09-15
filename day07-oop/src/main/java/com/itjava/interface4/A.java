package com.itjava.interface4;

public interface A {

    //JDK8开始，增加了三中接口的方法
    //增强了接口的能力，更易于维护和扩展

    //1.默认方法(普通实例方法),必须加default修饰
    //默认会用public修饰
    //如何调用？  使用接口的实例类的对象调用
    default void go() {
        System.out.println("调用了接口的默认方法（default修饰）");
        //2.调用私有实例方法
        run();
    }

    //2.私有方法，JDK9开始支持
    //私有的实例方法
    //如何调用？使用类中的其他实例方法来调用
    private void run(){
        System.out.println("调用了接口的私有实例方法（private修饰）");
    }

    //3.静态方法
    //默认用public修饰
    //如何调用？ 只能使用当前接口名来调用，他的实现类也不能用
    static void work(){
        System.out.println("调用了接口的静态方法（public static修饰）");
    }
}
