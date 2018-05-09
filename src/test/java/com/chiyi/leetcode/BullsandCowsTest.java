package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class BullsandCowsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getHint() throws Exception {
        assertEquals("1A0B",new BullsandCows().getHint("11","10"));
        assertEquals("1A2B",new BullsandCows().getHit2("3286","5826"));
        assertEquals("1A2B",new BullsandCows().getHint2("3286","5826"));
    }

}