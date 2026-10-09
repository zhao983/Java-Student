package com.itjava.demo2reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    //目的：获得类中的信息
    @Test
    public void getClassInfo() {
        //第一步操作，获得类本身
        //方式一：类.class
        Class c1 = Student.class;
        System.out.println(c1.getName()); //类的全类名
        System.out.println(c1.getSimpleName()); //类的类名
    }

    //获得类的构造器对象并对其进行操作
    @Test
    public void getConstructorInfo() throws Exception {
//        Class c1 = Student.class;  //@Data 的构造器不显示
        Class c1 = Teacher.class;
        //获得全部的构造器
//        Constructor[] cons = c1.getConstructors();  //获得所有共有的构造器

        Constructor[] cons = c1.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println("构造器名字" + con.getName() + "\t" + "构造器参数个数" + con.getParameterCount());
        }
        System.out.println("-------------------");
        //获得单个构造器
        Constructor con = c1.getDeclaredConstructor();  //获得无参构造器
        System.out.println("构造器名字" + con.getName() + "构造器参数个数" + con.getParameterCount());

        Constructor con2 = c1.getDeclaredConstructor(String.class, String.class); //获得两个参数的有参构造器
        System.out.println("构造器名字" + con2.getName() + "构造器参数个数" + con2.getParameterCount());
        System.out.println("-------------------");

        //获得构造器的作用依然是创建对象
        //暴力反射:暴力反射可以访问私有的构造器，方法和属性
        con.setAccessible(true);  //绕过权限，直接访问
        Teacher t1 = (Teacher) con.newInstance();  //调用无参构造器
        System.out.println(t1);

        Teacher t2 = (Teacher) con2.newInstance("张三","读书");
        System.out.println(t2);



    }

    //获得类的成员变量并对其进行操作
    @Test
    public void getFieldInfo() throws Exception {
        //第一步操作，获得类本身
        //方式一：类.class
        Class c1 = Teacher.class;
        //获得类的成员变量对象并进行操作
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("成员变量的名字：" + field.getName() + "\t" + "成员变量的类型名字：" + field.getType().getName());
        }
        System.out.println("------------------");
        //获得单个成员变量
        Field field = c1.getDeclaredField("sex");
        System.out.println("成员变量的名字：" + field.getName() + "\t" + "成员变量的类型名字：" + field.getType().getName());
        System.out.println("------------------");

        //获取成员变量的目的依然是取值和赋值
        Teacher teacher = new Teacher("张三","打球");
        field.setAccessible(true);
        field.set(teacher,"男");  //前面field取的是sex，这里也就是设置sex

        String str = (String) field.get(teacher);  //这里取得也会是性别 teacher.getSex();
        System.out.println(str);

    }

    //获得类的成员方法并对其进行操作
    @Test
    public void getMethodInfo() throws Exception {
        //第一步操作，获得类本身
        //方式一：类.class
        Class c1 = Teacher.class;
        //获得类的成员方法对象并进行操作
        Method[] methods = c1.getDeclaredMethods();  //获得全部的方法
        for (Method method : methods) {
            System.out.println("成员方法的名字" + method.getName() + "\t" + "成员方法的参数个数" + method.getParameterCount());

        }
        System.out.println("--------------");
        //获得单个方法
        Method method1 = c1.getDeclaredMethod("test");  //获得无参的test方法
        System.out.println("成员方法的名字" + method1.getName() + "\t" + "成员方法的参数个数" + method1.getParameterCount());

        Method method2 = c1.getDeclaredMethod("test",String.class);  //获得有参的test方法
        System.out.println("成员方法的名字" + method2.getName() + "\t" + "成员方法的参数个数" + method2.getParameterCount());
        System.out.println("----------------");

        //获取方法的目的依然是执行
        Teacher teacher = new Teacher("张三","打球");
        method1.setAccessible(true);
        //incoke()方法有返回值
        Object invoke1 = method1.invoke(teacher);//唤醒teacher的无参方法，相当于teacher.eat();
        System.out.println(invoke1);

        Object invoke2 = method2.invoke(teacher,"有参");//唤醒teacher的有参方法
        System.out.println(invoke2);
    }

}
