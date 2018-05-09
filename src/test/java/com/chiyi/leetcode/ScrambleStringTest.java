package com.chiyi.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class ScrambleStringTest {
    @Test
    public void isScramble() throws Exception {
        assertTrue(new ScrambleString().isScramble("a","a"));
    }

    @Test
    public void isScramble2() throws Exception {
        assertTrue(new ScrambleString().isScramble2("abc","acb"));
    }

}