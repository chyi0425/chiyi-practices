package com.chiyi.algorithms.sorting.elementary;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * The class Example illustrates the conventions that we shall use:
 * we put our sort code in a sort() method within a single class along with private helper function less() and exch()
 * and a sample client main().
 * @author chiyi
 */
public class Example {
    public static void sort(Comparable[] a){
        /* See Algorithms */
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        // print the array, on a single line.
        for(int i=0;i<a.length;i++){
            StdOut.print(a[i]+"");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        // Test whether the array entries are in order.
        for (int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Read string from standard input, sort them, and print.
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
