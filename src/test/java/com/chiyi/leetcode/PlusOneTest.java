package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/7
 */
public class PlusOneTest {
    private int[] param = {9,9};
    private int[] param2 = {0};
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void plusOne() throws Exception {
        int[] excepted = {1,0,0};
        int[] excepted2 = {1};
        assertArrayEquals(excepted,new PlusOne().plusOne(param));
        assertArrayEquals(excepted2,new PlusOne().plusOne(param2));
    }

}