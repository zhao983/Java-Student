package com.itjava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//自定义窗口类，创建一个对象，设计一个主窗口
public class MainFrame extends JFrame {
    //矩阵
    private static int[][] imageData = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //胜利矩阵
    private static final int[][] WIN_DATA = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //图片路径
    private static final String IMAGE_PATH = "stone-maze/src/main/java/images";
    //空白色块位置
    private int row; //行
    private int col; //列
    //加一个显示步数的功能
    private static int count;

    //有解的矩阵需要的一些成员
    private static final Random RANDOM = new Random();

    // 上、下、左、右
    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public MainFrame() {
        //1.定义一个方法，初始化窗口大小等信息
        initFrame();
        //4.打乱色块
        initRandomArray(imageData, 200);
        //2.定义一个方法，展示数字色块
        initImage();
        //3.初始化系统菜单 重启和退出
        initMenu();
        //5.监听上下左右按键按压事件
        initKeyPressEvent();
        //设置显示,要先初始化完再显示，所有显示要放在最后
        this.setVisible(true);
    }

    //1.定义一个方法，初始化窗口大小等信息
    private void initFrame() {
        //设置标题
        this.setTitle("石头迷阵");
        //设置宽高
        this.setSize(450, 575);
        //设置窗口居中显示
        this.setLocationRelativeTo(null);
        //设置窗口布局为局部布局
        this.setLayout(null);
        //设置退出方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //2.定义一个方法，展示数字色块
    private void initImage() {
        //先清除当前页面上的所有东西
        this.getContentPane().removeAll();

        //每次重绘完页面后判断是否胜利
        if (isWin()) {
            JLabel win = new JLabel();
            win.setIcon(new ImageIcon(IMAGE_PATH + "\\" + "win.png"));  //给图片的时候要再 new 一下
            //设置显示的位置
            win.setBounds(124,230,266,88);
            //把这个加到当前窗口上
            this.add(win);

        }

        //每次清除后重新显示步数
        JLabel countJLabel = new JLabel("当前移动" + count + "步");
        countJLabel.setBounds(0, 0, 100, 20);
        this.add(countJLabel);

        //展示一个行列矩阵显示图片
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                //拿到图片的名称
                String imageName = imageData[i][j] + ".png";
                //创建一个JLable，将图片给她
                JLabel jLabel = new JLabel();
                //注入图片
                jLabel.setIcon(new ImageIcon(IMAGE_PATH + "\\" + imageName));  //setIcon用来注入图片
                //将图片显示出来
                jLabel.setBounds(j * 100 + 25, i * 100 + 60, 100, 100);
                //把图片加到这个窗口上
                this.add(jLabel);

            }
        }

        //设置背景图片
        JLabel backgroundLabel = new JLabel(new ImageIcon(IMAGE_PATH + "\\" + "background.png"));
        backgroundLabel.setBounds(0, 0, 450, 484);
        this.add(backgroundLabel);

        //重新绘制页面
        this.repaint();



    }

    //定义方法判断是否相等
    private boolean isWin() {
        if (Arrays.deepEquals(imageData, WIN_DATA)) {
            return true;
        }
        return false;
    }

    //3.初始化系统菜单 重启和退出
    private void initMenu() {
        //创建一个按钮条
        JMenuBar jMenuBar = new JMenuBar();
        //创建一个菜单
        JMenu menu = new JMenu("系统");
        //创建需要的子按钮
        JMenuItem exitJi = new JMenuItem("退出");  //退出
        exitJi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //加到菜单上
        menu.add(exitJi);
        JMenuItem restartJi = new JMenuItem("重启");  //重启
        restartJi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //重启要求二维数组重新刷新加重新显示页面
                initRandomArray(imageData,200);
                initImage();
                //重启后步数设为0
                count = 0;
            }
        });
        menu.add(restartJi);
        //将菜单加到按钮条上
        jMenuBar.add(menu);
        //按钮条设置到窗口上
        this.setJMenuBar(jMenuBar);

    }

    //4.打乱色块
    /*
    private void initRandomArray() {
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                //随机两个数组中的数字互换
                int temp;
                int random1 = (int) (Math.random() * imageData.length);  //行随机
                int random2 = (int) (Math.random() * imageData[random1].length);  //在随机到行挑选随机列
                temp = imageData[i][j];
                imageData[i][j] = imageData[random1][random2];
                imageData[random1][random2] = temp;
            }
        }

        //得到空白色块的行列索引
        OUT:
        //声明
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if (imageData[i][j] == 0) {
                    row = i;
                    col = j;
                    //已经拿到后就不用再继续循环了
                    break OUT; //结束声明的循环
                }
            }
        }
    }
    */

    //一定有解的矩阵打乱
    //传输的两个参数分别是要打乱的数组和要打乱所进行的步数
    private void initRandomArray(int[][] imageData, int steps) {

        // 初始空格位置
        int emptyRow = 3;
        int emptyCol = 3;

        for (int i = 0; i < steps; i++) {

            List<int[]> canMove = new ArrayList<>();

            // 找出空格目前所有可以交换的位置
            for (int[] direction : DIRECTIONS) {

                int newRow = emptyRow + direction[0];
                int newCol = emptyCol + direction[1];

                if (newRow >= 0 && newRow < 4 &&
                        newCol >= 0 && newCol < 4) {

                    canMove.add(new int[]{newRow, newCol});
                }
            }

            // 随机选一个位置
            int[] move = canMove.get(
                    RANDOM.nextInt(canMove.size())
            );

            int newRow = move[0];
            int newCol = move[1];

            // 和空格交换
            imageData[emptyRow][emptyCol] = imageData[newRow][newCol];
            imageData[newRow][newCol] = 0;

            // 更新空格位置
            emptyRow = newRow;
            emptyCol = newCol;
        }

        //得到空白色块的行列索引
        OUT:
        //声明
        for (int i = 0; i < MainFrame.imageData.length; i++) {
            for (int j = 0; j < MainFrame.imageData[i].length; j++) {
                if (MainFrame.imageData[i][j] == 0) {
                    row = i;
                    col = j;
                    //已经拿到后就不用再继续循环了
                    break OUT; //结束声明的循环
                }
            }
        }
    }

    //5.监听上下左右按键按压事件(只监听)
    private void initKeyPressEvent() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                //再写一个枚举类来定义上下左右事件
                switch (keyCode) {
                    case KeyEvent.VK_UP -> switchAndMove(Direction.UP);
                    case KeyEvent.VK_DOWN -> switchAndMove(Direction.DOWN);
                    case KeyEvent.VK_LEFT -> switchAndMove(Direction.LEFT);
                    case KeyEvent.VK_RIGHT -> switchAndMove(Direction.RIGHT);
                }
            }
        });
    }

    //写一个方法来控制上下左右按键的反应(交换按键控制的图片)
    private void switchAndMove(Direction direction) {
        switch (direction) {
            case UP:
                System.out.println("用户点击了上");
                //当空白方块下面有方块时才能按上，也就是行索引要小于3(且大于等于0)
                if (row < 3 && row >= 0) {
                    //可以交换时将两个方块交换
                    int temp;
                    temp = imageData[row][col];
                    imageData[row][col] = imageData[row + 1][col];
                    imageData[row + 1][col] = temp;
                    //空白方块的行索引要加一
                    row++;
                    count++; //步数加一
                }
                break;
            case DOWN:
                System.out.println("用户点击了下");
                //当空白方块上面有方块时才能按下，也就是行索引大于0(且小于等于3)
                if (row <= 3 && row > 0) {
                    //可以交换时将两个方块交换
                    int temp;
                    temp = imageData[row][col];
                    imageData[row][col] = imageData[row - 1][col];
                    imageData[row - 1][col] = temp;
                    //空白方块的行索引要减一
                    row--;
                    count++; //步数加一
                }
                break;
            case LEFT:
                System.out.println("用户点击了左");
                //当空白方块右面有方块时才能按左，也就是列索引要小于3(且大于等于0)
                if (col < 3 && col >= 0) {
                    //可以交换时将两个方块交换
                    int temp;
                    temp = imageData[row][col];
                    imageData[row][col] = imageData[row][col + 1];
                    imageData[row][col + 1] = temp;
                    //空白方块的列索引要加一
                    col++;
                    count++; //步数加一
                }
                break;
            case RIGHT:
                System.out.println("用户点击了右");
                //当空白方块左面有方块时才能按右，也就是列索引要大于0(且小于等于3)
                if (col <= 3 && col > 0) {
                    //可以交换时将两个方块交换
                    int temp;
                    temp = imageData[row][col];
                    imageData[row][col] = imageData[row][col - 1];
                    imageData[row][col - 1] = temp;
                    //空白方块的列索引要减一
                    col--;
                    count++; //步数加一
                }
                break;
        }

        //执行完毕交换后重新绘制页面
        initImage();
    }

}
