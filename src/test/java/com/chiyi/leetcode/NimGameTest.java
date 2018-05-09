package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/7
 */
public class NimGameTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void canWinNim() throws Exception {
        assertTrue(new NimGame().canWinNim(3));
        assertFalse(new NimGame().canWinNim(4));
        assertFalse(new NimGame().canWinNim(8));
        assertTrue(new NimGame().canWinNim(9));
    }

}