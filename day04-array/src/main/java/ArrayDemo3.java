public class ArrayDemo3 {
    public static void main(String[] args) {
        start();

    }

    //五十四张扑克牌生成
    public static void start() {
        String[] pokers = new String[54];
        String poker = "";
        //定义颜色
        String[] color = {"♠", "♡", "♢", "♣"};
        //定义数字
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int index = 0;//定义pokers索引
        //一遍遍的遍历，让数字与花色匹配
        for (int i = 0; i < number.length; i++) {       // 数字
            for (int j = 0; j < color.length; j++) {    // 花色
                poker = number[i] + color[j];
                pokers[index] = poker;
                index++;
            }
        }
        pokers[index] = "大王";
        pokers[index + 1] = "小王";

        showPoker(pokers);//把显示牌独立为一个方法，节约资源，方便书写
        System.out.println("\n" + "------------------------------");

        //五十四张牌打乱
        //生成随机数，让五十四张牌随机交换
        index = 0;
        int ra = 0;//定义交换的随机数
        for (int i = 0; i < pokers.length; i++) {
            ra = (int) (Math.random() * pokers.length);
            poker = pokers[i];//从第一个开始交换
            pokers[i] = pokers[ra];//两个都要换
            pokers[ra] = poker;

        }//执行五十四次，直到所有的牌都被换过

        showPoker(pokers);
    }

    //五十四张牌显示
    public static void showPoker(String[] pokers) {
        int line = 0;
        for (int i = 0; i < pokers.length; i++) {
            System.out.printf(pokers[i] + "\t");
            line++;
            if ((line % 4) == 0)
                System.out.println();
        }
    }
}
