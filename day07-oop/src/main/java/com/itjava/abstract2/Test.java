package com.itjava.abstract2;

//父类知道每个子类都要做某个行为，但每个子类要做的情况不一样，父类就定义成抽象方法，交给子类去重写实现，我们抽出这样的抽象类，就是为了更好的支持多态。
public class Test {
    public static void main(String[] args) {
        Animal a1 = new Dog();
//      Animal a1 = new Cat();  //解耦性也好
        a1.cry();

    }
}
