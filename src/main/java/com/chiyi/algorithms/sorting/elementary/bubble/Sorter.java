package com.chiyi.algorithms.sorting.elementary.bubble;

import java.util.Comparator;

/**
 * sorter interface
 * @author chiyi
 */
public interface Sorter {

    /**
     * sort
     * @param list the array wait to sort
     * @param <T>
     */
    <T extends Comparable<T>> void sort(T[] list);

    /**
     * sort
     * @param list the array wait to sort
     * @param comp the comparator
     * @param <T>
     */
    <T> void sort(T[] list ,Comparator<T> comp);
}
