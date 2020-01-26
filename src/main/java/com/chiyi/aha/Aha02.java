package com.chiyi.aha;

import java.util.Scanner;

/**
 * 简化版桶排序
 */
public class Aha02 {
    public static void main(String[] args) {
        int book[] = new int[1001];
        int i, j, t, n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (i = 1; i <= n; i++) {
            t = in.nextInt();
            book[t]++;
        }
        for (i = 1000; i >= 0; i--) {
            for (j = 1; j <= book[i]; j++) {
                System.out.printf("%d", i);
                System.out.println();
            }
        }
    }
}
