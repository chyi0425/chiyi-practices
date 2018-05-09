package com.chiyi.leetcode;

import java.util.Arrays;


/**
 * @author chiyi
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        // ASCII table can represent a total of 256 characters
        int[] m = new int[256];
        // m[charAt(i)] init as -1
        Arrays.fill(m,-1);
        int res = 0, left = -1;
        for(int i=0;i<s.length();i++){
            // if the char is repeat,left will be changed
            left = Math.max(left,m[s.charAt(i)]);
            // set m[charAt(i)]'value as i
            m[s.charAt(i)]=i;
            // i-left is the length of not repeat
            res = Math.max(res,i-left);
        }
        return res;
    }

}
