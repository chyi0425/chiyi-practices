package com.chiyi.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class PascalTriangleTest {
    @Test
    public void generate() throws Exception {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> res = pascalTriangle.generate(4);
        System.out.println(res);
    }

}