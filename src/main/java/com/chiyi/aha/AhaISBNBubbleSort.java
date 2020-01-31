package com.chiyi.aha;

import java.util.Scanner;

public class AhaISBNBubbleSort {
    public static void main(String[] args) {
        int[] a = new int[101];
        int n, t;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        // start bubble sort
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; i <= n - i; j++) {
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        System.out.printf("%d ", a[1]);
        for (int i = 2; i <= n; i++) {
            if (a[i] != a[i - 1]) {
                System.out.printf("%d ", a[i]);
            }
        }
    }
}
