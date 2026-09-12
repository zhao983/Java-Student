package com.javademo.polymorphsm2;

//多态的好处
public class Test {
    public static void main(String[] args) {

        Animal a1 = new Tortoise();
        //1.多态的右边是解耦合的,更易于扩展和维护
        //Animal a1 = new Wolf();觉得右边的不好就可以换掉，下面的代码不用变
        //用在行业中比如右边的代码可以找不同的公司设计，哪家设计的好就用哪家，不用改下面的代码
        a1.run();

        //2.父类类型的变量做参数时，可以接受一切子类对象
//        Wolf aWolf = new Wolf();
        Animal aWolf = new Wolf();
//        Tortoise aTortoise = new Tortoise();
        Animal aTortoise = new Tortoise();
        System.out.println("----------------");
        go(aWolf);
        go(aTortoise);

        //多态的缺点：多态不能调用子类独有的功能
        Animal animal = new Wolf();
        //animal.eatSheep();  报错

        System.out.println("-----------------");

        //但多态可以进行强制类型转换，转换后就能使用子类的方法
        Wolf wolf = (Wolf) animal;
        wolf.eatSheep();
        //有继承关系时可以转换，没有时在编译的时候不会报错，但在运行时候会报错:类型转换异常(ClassCastException)
//        Wolf anWolf = (Wolf) aTortoise; //乌龟转狼

        System.out.println("------------------");
        forceTrasition(aWolf);
        forceTrasition(aTortoise);

    }

    public static void go(Animal a) {  //等会要再main中访问，加一下static
        a.run();
    }

    public static void forceTrasition(Animal a){
        //java建议在强制转换前要用instanceof来判断对象的真实类型，再进行转换
        if(a instanceof Wolf){
            ((Wolf) a).eatSheep();
        } else if (a instanceof Tortoise) {
            ((Tortoise) a).lifeLong();
        }

    }
}
