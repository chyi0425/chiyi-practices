package com.chiyi.algorithms.sorting.elementary;

/**
 * selection sort.
 * First,find the smallest item in the array and exchange it with the first entry(itself if the first entry is already the smallest).
 * Then,find the next smallest item and exchange it with the second entry.Continue in this way until the entire array is sorted.
 * This method is called selection sort because it works by repeatedly selecting the smallest remaining item.
 *
 * selection sort is a simple sorting method that is easy to understand and to implement and is characterized by the following two signature properties:
 * Running time is insensitive to input.
 * Data movement is minimal.
 * @author chiyi
 */
public class Selection extends Example {
    public static void sort(Comparable[] a){
        // Sort a[] into increasing order.
        for(int i=0;i<a.length;i++){
            // Exchange a[i] with smallest entry in a[i+1...N].
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }
}
