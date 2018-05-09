package com.chiyi.algorithms.sorting.elementary;

/**
 * As in selection sort,the items to the left of the current index are in sorted order during the sort,but they are not
 * in their final position,as they may have to be moved to make room for smaller items encountered later.The array is,
 * however,fully sorted when the index reaches the right end.
 * Unlike that of selection sort,the running time of insertion sort depends on the initial order of the items in the
 * input.For example,if the array is large and tis entries are already in order(or nearly in order),the insertion sort
 * is much,much faster than if the entries are randomly ordered or in reverse order.
 * @author chiyi
 */
public class InsertionSort extends Example {
    public static void sort(Comparable[] a){
        // Sort a[] into increasing order.
        for(int i=1;i<a.length;i++){
            // Insert a[i] among a[i-1],a[i-2],a[i-3]...
            for (int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
}
