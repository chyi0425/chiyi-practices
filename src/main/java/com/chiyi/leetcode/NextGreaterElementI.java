package com.chiyi.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chiyi
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek()<=nums[i]){
                stack.pop();
            }
            map.put(nums[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums[i]);
        }
        for(int i=0;i<findNums.length;i++){
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}
