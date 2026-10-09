package com.itjava.demo3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        String info = "10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺" +
                "#10003,周芷若,女,2023-07-22 04:11:21,木兰文化区-东湖#10004,小昭,女,2023-07-22 08:11:21,东湖#10005,灭绝,女,2023-07-22 17:11:21,归元禅寺";
        //把这个转成List<Student>对象
        List<Student> students = parseStudent(info);
        System.out.println(students);

        System.out.println("-----------------");
        //可以用Map来处理景点和投票数
        //用景点作为键，选择次数作为值
        Map<String, Integer> addresses = addressCount(students);
        System.out.println(addresses);

        addressMax(addresses,students);
    }
    //  业务三：
    public static void addressMax(Map<String,Integer> addresses,List<Student> students){
        //创建一个景点对象用来接受最多人想去的景点 先定义景点类
        Address address = new Address();
        //创建一个集合用来存储所有的景点
        List<Address> list = new ArrayList<>();
        //遍历Map集合  根据键遍历
        for(String s : addresses.keySet()){
            list.add(new Address(s,addresses.get(s)));
        }
        address=list.get(0);
        //找投票数最多的那个
        for(Address a : list){
            if(address.getCount()<a.getCount()){
                address=a;
            }
        }
        System.out.println(address.getName());

        //一行搞定
        //return map.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get().getKey();

        //输出没有选东湖的学生
        System.out.println("没有选东湖的学生");
        for(Student student : students){
            if(!student.getAddress().contains(address.getName())){
                System.out.println(student.getName());
            }
        }

        //这个也可以用Stream流
    }

    //  业务二：
    public static Map<String, Integer> addressCount(List<Student> students) {
        Map<String, Integer> addresses = new HashMap<>();
        addresses.put("东湖", 0);
        addresses.put("黄鹤楼", 0);
        addresses.put("木兰文化区", 0);
        addresses.put("归元禅寺", 0);
        for (Student student : students) {
            if (student.getAddress().contains("东湖")) {
                addresses.put("东湖", addresses.get("东湖") + 1);
            }
            if (student.getAddress().contains("黄鹤楼")) {
                addresses.put("黄鹤楼", addresses.get("黄鹤楼") + 1);
            }
            if (student.getAddress().contains("木兰文化区")) {
                addresses.put("木兰文化区", addresses.get("木兰文化区") + 1);
            }
            if (student.getAddress().contains("归元禅寺")) {
                addresses.put("归元禅寺", addresses.get("归元禅寺") + 1);
            }
        }
        return addresses;
    }


    //  业务一：
    public static List<Student> parseStudent(String info) {
        //创建学生集合用于返回
        List<Student> students = new ArrayList<>();
        //创建时间格式解析
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //用split分割字符串
        String[] strs = info.split("#");
        //再分割每一个学生的字符串信息
        for (String str : strs) {
            String[] msg = str.split(",");
            Long id = Long.valueOf(msg[0]);
            String name = msg[1];
            String sex = msg[2];
            LocalDateTime ldt = LocalDateTime.parse(msg[3], dtf);
            String address = msg[4];
            students.add(new Student(id, name, sex, ldt, address));
        }
        return students;
    }
}
