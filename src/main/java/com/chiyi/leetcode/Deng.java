package com.chiyi.leetcode;

import java.util.Scanner;

/**
 * @author chiyi
 */
public class Deng {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//读取灯的数目
        boolean[] a = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {//初始化灯的状态，false表示亮着，true代表关闭
            a[i] = false;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (j % i == 0) {
                    a[j] = light(a[j]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (a[i] == false) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean light(boolean l) {
        if (true == l) {
            return false;
        } else {
            return true;
        }
    }
}
