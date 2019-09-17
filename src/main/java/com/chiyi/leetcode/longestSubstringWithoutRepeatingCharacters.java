package com.chiyi.leetcode;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        while (j < length) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }else {
                set.add(s.charAt(j++));
                maxLen = Integer.max(j - i, maxLen);
            }
        }
        return maxLen;
    }
}
