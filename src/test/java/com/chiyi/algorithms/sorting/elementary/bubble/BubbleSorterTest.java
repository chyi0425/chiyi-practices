package com.chiyi.algorithms.sorting.elementary.bubble;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class BubbleSorterTest {
    BubbleSorter bubbleSorter = new BubbleSorter();
    @Test
    public void sort() throws Exception {
        Integer[] list = {1,3,52,2,7,30};
        bubbleSorter.sort(list);
    }

    @Test
    public void sort1() throws Exception {

    }

}