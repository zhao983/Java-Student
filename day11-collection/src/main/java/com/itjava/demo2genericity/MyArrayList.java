package com.itjava.demo2genericity;

// E：(element) 元素类型  T： (type) 具体的一个java类型 返回值类型
// K V (key value) 分别代表java键值中的Key Value
// ？表示不确定的 java 类型

import java.util.ArrayList;

//自定义泛型类
public class MyArrayList<E> {
    private ArrayList list = new ArrayList<>();

    //把要操作的元素类型用E表示
    public boolean myAdd(E e){
        list.add(e);
        return true;
    }

    public boolean myRemove(E e){
        list.remove(e);
        return true;
    }

    public String mytoString() {
        return list.toString();
    }
}
