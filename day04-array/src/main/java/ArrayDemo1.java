public class ArrayDemo1 {
    public static void main(String[] args) {
        arrayTest();

    }

    //数组的定义
    public static void arrayTest() {
        String names[] = {"张三", "李四", "王五", "赵六"};
        //数组索引从0开始     0      1     2      3
        System.out.println(names[0]);
        System.out.println("------------------");
        //String[] names = {"张三","李四","王五","赵六"};
        //[]也可以放在类型定义后面
        int index = (int) (Math.random() * names.length);
        String name = names[index];
        System.out.println(name);
        System.out.println("------------------");
        int[] counts = {1, 5, 9, 11, 56};
        index = (int) (Math.random() * counts.length);
        int count = counts[index];
        System.out.println(count);

    }
}
