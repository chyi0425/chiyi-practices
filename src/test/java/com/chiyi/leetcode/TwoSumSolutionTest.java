package com.chiyi.leetcode;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/6
 */
public class TwoSumSolutionTest {

    @org.junit.Test
    public void twoSum() throws Exception {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] nums = {1,3,2,5};
        int target = 6;
        int[] result = twoSumSolution.twoSum(nums,target);
        int[] expecteds = {0,3};
        assertArrayEquals(expecteds,result);
        int[] result2 = twoSumSolution.twoSumHash(nums,target);
        assertArrayEquals(expecteds,result2);
    }

    @org.junit.Test
    public void demo() throws Exception {
        char arr[]=new char[26];
        int i;
        for(i=0;i<26;i++){
            if(i<26) {
                arr[i] = (char) ('A' + i);
            }else{
                arr[i]=(char)('a'+(i-26));
            }
        }
        System.out.println(Arrays.toString(arr));

    }

}