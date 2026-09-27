package com.itjava.demo2map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*方法名称	说明
public V put(K key,V value)	添加元素
public int size()	获取集合的大小
public void clear()	清空集合
public boolean isEmpty()	判断集合是否为空，为空返回true ，反之
public V get(Object key)	根据键获取对应值
public V remove(Object key)	根据键删除整个元素
public boolean containsKey(Object key)	判断是否包含某个键
public boolean containsValue(Object value)	判断是否包含某个值
public Set<K> keySet()	获取全部键的集合
public Collection<V> values()	获取Map集合的全部值*/

public class MapDemo2 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();  //LinkedHashMap有序，不重复，无索引
        map.put("嫦娥", 20);
        map.put("女儿国国王", 31);
        map.put("嫦娥", 28);  //键相同的情况下后来的值会覆盖前面的值
        map.put("铁扇公主", 38);
        map.put("紫霞", 31);
        map.put(null, null);
        System.out.println(map);

        // 写代码演示常用方法
        System.out.println(map.get("嫦娥")); // 根据键取值  28
        System.out.println(map.get("嫦娥2")); // 根据键取值  null

        System.out.println(map.containsKey("嫦娥")); // 判断是否包含某个键 true
        System.out.println(map.containsKey("嫦娥2")); // false

        System.out.println(map.containsValue(28)); // 判断是否包含某个值 true
        System.out.println(map.containsValue(28.0)); // false

        System.out.println(map.remove("嫦娥")); // 根据键删除键值对, 返回值
        System.out.println(map);

        // map.clear(); // 清空map
        // System.out.println(map);

        System.out.println(map.isEmpty()); // 判断是否为空

        System.out.println(map.size()); // 获取键值对的个数 4
        System.out.println("------------");
        //获取所有的键放到一个集合中
        //因为键无重复，无需，无索引，所以可以放到Set集合中
        Set<String> keys = map.keySet();
        for (String key : keys){
            System.out.println(key);
        }
        System.out.println("------------");
        //获取所有的值放到一个集合中
        //因为键可重复，所以可以放到COllection集合中
        Collection<Integer> values = map.values();
        for (Integer value : values){
            System.out.println(value);
        }
    }
}
