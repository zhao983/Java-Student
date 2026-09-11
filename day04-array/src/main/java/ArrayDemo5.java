import java.util.Scanner;

public class ArrayDemo5 {
    public static void main(String[] args) {
        arrayTest();
    }

    //石头矩阵
    public static void arrayTest() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("请输入矩阵大小:");
        n = sc.nextInt();
        int[][] count = new int[n][n];
        //石头矩阵的初始化输入
        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = ++number;
            }
        }
        printTest(count);
        System.out.println("--------------------------");
        //矩阵打乱
        //需要行和列两个随机数,定义为m，p
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                int m = (int) (Math.random() * count.length);
                int p = (int) (Math.random() * count.length);
                num = count[i][j];
                count[i][j] = count[m][p];
                count[m][p] = num;
            }
        }
        printTest(count);


    }

    //矩阵输出
    public static void printTest(int[][] count) {
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i].length; j++) {
                System.out.printf(count[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
