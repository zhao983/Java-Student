package com.javademo.demo;

import java.util.Scanner;

//打印某两个数字之间所有的整数
public class PrimeTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数字的范围");
        int st = sc.nextInt();
        int end = sc.nextInt();
        int j = 0;
        for (int i = st; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                j++;
                if ((j % 5) == 0)
                    System.out.println();
            }

        }

    }

    //判读一个数是否为素数，可以看2到它的开平方根(求法：Math.sqrt())有没有数字可以和他整数，没有则为素数
    public static boolean isPrime(int prime) {
        if (prime < 2) {
            return false;
        }//先判断1
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) {
                //if (prime % i == 0 || prime == 1){  如果prime=1，则上面的for语句根本不会执行，所以会直接到retur true；
                return false;
            }
        }
        return true;

    }
}
