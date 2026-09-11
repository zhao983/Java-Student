import java.util.Scanner;

public class ArrayDemo2 {
    public static void main(String[] args) {
        inputScore();

    }
    //认识动态数组
   /* 数据类型	明细	                     默认值
    基本类型	byte、short、char、int、long	  0
               float、double	          0.0
               boolean	                  false
    引用类型	  类、接口、数组、String	      null      */


    //假设班级有8名学生，请帮我开发程序可以录入8名学生的Java成绩，成绩类型是小数，并输出平均分，最高分和最低分。
    public static void inputScore() {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[5];
        //"="前面定义数组，"="后面 new 数据类型[数组大小]

        //输入所有学生的成绩
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("请输入第%d个学生的成绩", i + 1);
            scores[i] = sc.nextInt();
        }
        //求成绩和
        int sumscores = 0;
        for (int i = 0; i < scores.length; i++) {
            sumscores += scores[i];
        }
        System.out.println("成绩之和为：" + sumscores);
        //平均分
        System.out.println("成绩之和为：" + (sumscores / scores.length));

        //求最大值
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            /*if (max < scores[i]) {
                max = scores[i];  要找两边数组，浪费性能
            }*/
            int data = scores[i]; //只找一次数组，节约性能
            if (max < data) {
                max = data;
            }
        }
        System.out.println("最高分为：" + max);
    }

}
