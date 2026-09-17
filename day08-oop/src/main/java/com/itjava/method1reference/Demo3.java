package com.itjava.method1reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Demo3 {
    public static void main(String[] args) {
        //目标：理解构造器引用
    /*
    AnimalCry animalCry =new AnimalCry() {
        @Override
        public void cry(String voice) {
            System.out.println("喵");
        }
    }
    */
        //简化
        //AnimalCry animalCry = voice -> new Animal(voice);
        //接着简化
        //构造器引用
        //格式
        //类名 :: new
        AnimalCry animalCry = Animal::new;
        Animal animal = animalCry.cry("喵");
        System.out.println(animal);
    }

}

interface AnimalCry{  //专门用来创建动物对象
    Animal cry(String voice);
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Animal {
    private String voice;
}