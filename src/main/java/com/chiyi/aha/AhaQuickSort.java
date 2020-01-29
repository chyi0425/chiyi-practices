package com.chiyi.aha;

import java.util.Scanner;

public class AhaQuickSort {
    static int[] a = new int[101];
    static int n;

    public static void main(String[] args) {
        int i, j, t;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        quickSort(1, n);
        for (i = 1; i <= n; i++) {
            System.out.printf("%d ", a[i]);
        }
    }

    private static void quickSort(int left, int right) {
        int i, j, t, tmp;
        if (left > right) {
            return;
        }
        tmp = a[left];  // tmp存储基准数
        i = left;
        j = right;
        while (i != j) {
            // 顺序很重要，要先从右往左找
            while (a[j] >= tmp && i < j) {
                j--;
            }
            // 再从左往右找
            while (a[i] <= tmp && i < j) {
                i++;
            }
            // 交换两个数在数组中的位置
            if (i < j) {// 当哨兵i和哨兵j没有相遇时
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        // 最终将基准数归位
        a[left] = a[i];
        a[i] = tmp;

        quickSort(left, i - 1);// 继续处理左边的，递归
        quickSort(i + 1, right);// 继续处理右边的，递归
    }

}
