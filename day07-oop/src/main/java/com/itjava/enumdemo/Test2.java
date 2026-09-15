package com.itjava.enumdemo;

//枚举类适合做信息分类和标志
public class Test2 {
    public static void main(String[] args) {
        //需求：模拟上下左右移动图片
        //第一种是用常量做信息约束，但数值不受约束
        moveConstance(Constant.UP);
        //moveConstance(100);  比如这里传个100的值，因为下面定义的数据类型是int，所以也能传过去

        //第二种使用枚举类做信息约束,只有这几种，不能随便传输
        moveEnum(Direction.UP);
    }

    public static void moveConstance(int move) {
        switch (move) {
            //用枚举类的时候，case能自动识别要用到是枚举类，不需要再在前面写类名.
            //case Direction.DOWN:
            case Constant.UP:
                System.out.println("向上移动");
                break;
            case Constant.DOWN:
                System.out.println("向下移动");
                break;
            case Constant.LEFT:
                System.out.println("向左移动");
                break;
            case Constant.RIGHT:
                System.out.println("向右移动");
                break;
            default:
                System.out.println("输入的值有误");
        }
    }

    public static void moveEnum(Direction direction) {
        switch (direction) {
            //用枚举类的时候，case能自动识别要用到是枚举类，不需要再在前面写类名.
            //case Direction.DOWN:
//          case UP -> System.out.println("向上移动");
//          这种 case ... -> 写法执行完当前分支后，会自动结束这个分支，不会继续“掉进”下一个 case，所以不用写：break;
            case UP:
                System.out.println("向上移动");
                break;
            case DOWN:
                System.out.println("向下移动");
                break;
            case LEFT:
                System.out.println("向左移动");
                break;
            case RIGHT:
                System.out.println("向右移动");
                break;
        }
    }
}
