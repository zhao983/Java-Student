public class ArrayDemo4 {
    public static void main(String[] args) {
        printAr();

    }

    //认识二维数组
    public static void printAr() {
        //静态二维数组
        String[][] names = {
                {"张三", "李四", "王五"},
                {"赵六", "洞七"},
                {"李酒", "顺十", "唐十一", "柯十二"}
        };
        //动态二维数组
        int[][] number = new int[3][4];

        System.out.println(names.length);//显示长度为数组的行数（第一个[数字]）
        System.out.println(names[2].length);//显示该列的长度

        printArray(names);


        System.out.println("-----------------------");
        //尝试班级座位打乱
        //需要行和列两个随机数,定义为m，p
        String name = "";
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                int m = (int) (Math.random() * names.length);
                int p = (int) (Math.random() * names[m].length);//换到的m行注意一下
                name = names[i][j];
                names[i][j] = names[m][p];
                names[m][p] = name;
            }
        }
        printArray(names);

    }

    //如何打印第一个那样的不规则的数组？
    public static void printArray(String[][] names){
        //一：直接循环输出
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                System.out.printf(names[i][j] + "\t");
            }
            System.out.println();//换行
        }

        System.out.println("-----------------------");
        //二：造一个中转输出
        for (int i = 0; i < names.length; i++) {
            String[] names1 = names[i];//这样会取i那一行的值赋给names1
            for (int j = 0; j < names1.length; j++) {
                System.out.printf(names1[j] + "\t");
            }
            System.out.println();

        }
    }
}
