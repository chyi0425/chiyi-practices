package com.chiyi.leetcode;

/**
 * @author chiyi
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums){
        int answer = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(i!=nums.length && nums[i]==1){
                count++;
            }else {
                if(count ==0){
                    continue;
                }
                answer = answer>count?answer:count;
                count = 0;
            }
        }
        answer = answer>count?answer:count;
        return answer;
    }
}
