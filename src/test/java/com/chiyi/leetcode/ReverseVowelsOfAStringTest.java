package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class ReverseVowelsOfAStringTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void reverseVowels() throws Exception {
        assertEquals("abcde",new ReverseVowelsOfAString().reverseVowels("ebcda"));
    }

}