package com.chiyi.leetcode;

/**
 * @author chiyi
 * @date 2019/6/12.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Integer.min(minLen, strs[i].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

                if (c != strs[j].charAt(i)) {
                    break ;
                }
            }
        }
        return "";
    }
}
