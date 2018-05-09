package com.chiyi.leetcode;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/6
 */
public class TwoSumSolutionTest {

    @org.junit.Test
    public void twoSum() throws Exception {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] nums = {1,3,3};
        int target = 6;
        int[] result = twoSumSolution.twoSum(nums,target);
        int[] expecteds = {1,2};
        assertArrayEquals(expecteds,result);
        int[] result2 = twoSumSolution.twoSumHash(nums,target);
        assertArrayEquals(expecteds,result2);
    }

}