package com.itjava.demo3genericity;

public interface Data <T>{
//    void add(Student s);
//    void add(Teacher s);
    void add(T t);
    void delete(T t);
    void updata(T t);
    T quer(int id);  //查询
}
