package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/7
 */
public class EvaluateReversePolishNotationTest {
    private String[] param1 = {"4", "13", "5", "/", "+"};
    private String[] param2 = {"2", "1", "+", "3", "*"};
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void evalRPN() throws Exception {
        assertEquals(6,new EvaluateReversePolishNotation().evalRPN(param1));
        assertEquals(9,new EvaluateReversePolishNotation().evalRPN(param2));
    }

}