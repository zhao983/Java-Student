package com.itjava.demo8api;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test3 {
    public static void main(String[] args) {
        // 目标：掌握BigDecimal解决小数运算结果失真问题。
        double a = 0.1;
        double b = 0.2;
        System.out.println(a + b); // 0.30000000000000004

        // 如何解决呢？ 使用BigDecimal
        // 1、把小数包装成BigDecimal对象来运算才可以。
        // 必须使用 public BigDecimal(String val) 字符串构造器才能解决失真问题
        // BigDecimal a1 = new BigDecimal(Double.toString(a));
        // BigDecimal b1 = new BigDecimal(Double.toString(b));

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        BigDecimal c1 = a1.add(b1);

        //还需要将结果转换为double类型
        double c = c1.doubleValue();
        System.out.println(c);

        BigDecimal a2 = BigDecimal.valueOf(0.1);
        BigDecimal b2 = BigDecimal.valueOf(0.3);
        //除法                         保留几位    处理方法(四舍五入)
        BigDecimal c2 = a2.divide(b2,2, RoundingMode.HALF_DOWN);
        double r = c2.doubleValue();
        System.out.println(r);
    }
}
