package com.javademo.object;

public class Students {
    /*
    String name = "";
    double math = 0;
    double chinese = 0;
    double sumScore = math+chinese;
    sumScore = math+chinese;  Java 的类里面不能直接放这种普通执行语句：
    double average = sumScore/2;
    average = sumScore/2;     Java 的类里面不能直接放这种普通执行语句：
    这样定义double sumScore = math+chinese;double average = sumScore/2
    会导致结果为
    0.0
    0.0
    因为上面已经定义了math和chinese为0，sumScore和average不会在有新的定义时重新计算
    成员变量不需要为了“防止报错”而特意赋初始值，因为 Java 会自动给它们默认值。
    比如：
    常见默认值是：
     类型	             默认值
    int、long 等整数	      0
    double、float	     0.0
    boolean	false
    char	              '\u0000'
    String、数组、对象	  null
    */

    String name;
    double math;
    double chinese;
    /*
    double sumScore = math+chinese;
    double average = sumScore/2;
    这样也不行，也不会重新计算
    */


    //封装：把数据和对数据的处理放到同一个类中
    public void printSumScore() {
        System.out.println(math + chinese);
    }

    public void printAverage() {
        System.out.println((math + chinese) / 2);
    }

}
