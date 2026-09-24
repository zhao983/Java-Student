package com.itjava.demo6collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo3 {
    public static void main(String[] args) {
        //目标：掌握Collection的遍历方式一 迭代器遍历 (只能遍历集合)
        ArrayList<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);

        //1.得到这个集合的迭代器对象
        Iterator<String> it = names.iterator();
        //2.使用while循环遍历
        while (it.hasNext()){  //hasNext() 判断当前循环有无数据
            System.out.println(it.next());
        }
    }
}

//方法	           作用
//hasNext()	    判断后面是否还有可以获取的元素
//next()	    获取下一个元素，并向后移动

//对比	Scanner.next()	Iterator.next()
//所属类型	Scanner 类	Iterator 接口
//主要作用	读取下一个输入内容片段	获取集合中的下一个元素
//数据来源	键盘、文件等输入源	集合
//返回类型	String	由迭代器的泛型决定
//常见搭配	Scanner(System.in)	hasNext()