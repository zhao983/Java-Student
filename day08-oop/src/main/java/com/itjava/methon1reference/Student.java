package com.itjava.methon1reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int age;

    public static int compareByAge1(Student o1,Student o2){
        return o1.getAge()- o2.getAge();
    }

    public int compareByAge2(Student o1,Student o2){
        return o1.getAge()- o2.getAge();
    }
}
