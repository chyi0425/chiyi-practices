package com.chiyi.aha;

import java.util.Scanner;

public class AhaPop {
    public static void main(String[] args) {
        int[] a;
        int i, j, t, n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n + 1];
        for (i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (i = 1; i <= n - 1; i++) {
            for (j = 1; j <= n - i; j++) {
                if (a[j] < a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        for (i=1;i<=n;i++){
            System.out.printf("%d ",a[i]);
        }
    }
}
