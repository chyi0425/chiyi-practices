package com.chiyi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @author chiyi
 * @date 2017/3/6
 */
public class TwoSumSolution {
    public int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSumHash(int[] nums,int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
            map.put(diff,i);
        }
        return result;
    }
}
