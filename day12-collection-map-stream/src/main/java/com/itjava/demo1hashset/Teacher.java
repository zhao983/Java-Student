package com.itjava.demo1hashset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Comparable<Teacher> {
    private String name;
    private int age;
    private double salary;

    //如果认为左边大于右边，就返回正数，认为应该小于返回负数，相等返回0
   /* @Override
    public int compareTo(Teacher o) {
        //按年龄升序排列
//        if(this.getAge()>o.getAge()) return 1;
//        if (this.getAge()<o.getAge()) return -1;
//        return 0;
        //简化
//        return this.getAge() - o.getAge(); //但这样会让年龄相等的没办法正确存入，解决方法就是不返回0
        if (this.getAge() > o.getAge()) return 1;
        return -1;
    }*/

    @Override
    public int compareTo(Teacher o) {
        int result = Integer.compare(this.age, o.age);

        if (result != 0) {
            return result;
        }

        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + "\n";
    }
}
