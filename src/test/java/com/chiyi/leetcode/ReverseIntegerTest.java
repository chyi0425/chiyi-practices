package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/8
 */
public class ReverseIntegerTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void reverse() throws Exception {
        assertEquals(123,new ReverseInteger().reverse(321));
        assertEquals(-123,new ReverseInteger().reverse(-321));
    }

}