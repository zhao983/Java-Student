package com.javademo.extends1demo;

//认识private，缺/省，proctected，public四种类型的修饰范围
public class Fu {

    //private:只能本类
    private void printPrivate() {
        System.out.println("Private");
    }

    //缺/省	本类、同一个包中的类
    void print() {
        System.out.println("缺/省");
    }

    //    protected	本类，同一个包中的类、子孙类中
    protected void printProtected() {
        System.out.println("Protected");
    }

    //    public	任意位置
    public void printPublic() {
        System.out.println("Public");
    }

    public static void main(String[] args) {
        Fu f = new Fu();
        f.printPrivate();
        f.print();
        f.printProtected();
        f.printPublic();

    }
}
