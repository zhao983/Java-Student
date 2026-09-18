package com.itjava.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    //"工号", "姓名", "年龄", "入职日期","部门", "职位", "薪资"
    private int id;
    private String name;
    private int age;
    private String entryDate;
    private String dept;
    private String position;
    private double salary;


}
