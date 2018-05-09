package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class LongestPalindromicSubstringTest {
    LongestPalindromicSubstring longestPalindromicSubstring;
    @Before
    public void setUp() throws Exception {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    public void longestPalindrome() throws Exception {
        longestPalindromicSubstring.longestPalindrome("babad");
    }

}