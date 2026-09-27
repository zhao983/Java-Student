package com.itjava.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverseDemo3 {
    public static void main(String[] args) {
        //掌握Map集合的三种遍历方式
        Map<String, Integer> map = new HashMap<>();  //LinkedHashMap有序，不重复，无索引
        map.put("嫦娥", 20);
        map.put("女儿国国王", 31);
        map.put("嫦娥", 28);  //键相同的情况下后来的值会覆盖前面的值
        map.put("铁扇公主", 38);
        map.put("紫霞", 31);
        map.put(null, null);
        System.out.println(map);

        //方式一：键找值
        //先取所有的键值，再根据键值遍历Set集合，得到每一个值
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println("----------------");

        //方式二：键值对
        //用Map提供的方法，把键值对转换成一个对象，存入Set集合中  Set<Map.Entry<k, v>>
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        //然后再遍历Set集合
        for (Map.Entry<String, Integer> entry : entries) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key+"="+value);
            System.out.println(entry);
        }
        System.out.println("----------------");

        //方式三：Lambda表达式
        //需要用forEach(new BiConsumer<K,V>())
        /*
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+"="+integer);
            }
        });
        */
        //简化
        map.forEach((k, v) -> System.out.println(k + "=" + v));  // System.out.println里面的不同的数据要用 "+" 连接
    }
}
