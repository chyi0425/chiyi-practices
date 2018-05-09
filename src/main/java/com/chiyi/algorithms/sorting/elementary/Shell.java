package com.chiyi.algorithms.sorting.elementary;

public class Shell extends Example {
    public static void sort(Comparable[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            System.out.println("gap="+gap);
            for (int i = gap; i < a.length; i++) {
                System.out.println("i="+i);
                for (int j = i; j - gap >= 0 && less(a[j], a[j - gap]); j -= gap) {
                    exch(a,j,j-gap);
                }
            }
        }
    }
}
