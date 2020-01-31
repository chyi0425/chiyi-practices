package com.chiyi.aha;

import java.util.Scanner;

public class AhaISBNBucketSort {
    public static void main(String[] args) {
        int[] a = new int[1001];
        int n, t;
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 读入n
        for (int i = 1; i <= n; i++) {//循环读入n个读书的ISBN号
            t = in.nextInt();       // 把每一个ISBN号读到变量t中
            a[t] = 1; // 标记出现过的ISBN号
        }
        for (int i = 1; i <= 1000; i++) {
            if (a[i] == 1) {
                System.out.printf("%d ", i);
            }
        }
    }
}
