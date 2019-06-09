package com.chiyi.leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length()-1 || hashMap.get(s.charAt(i)) >= hashMap.get(s.charAt(i + 1))) {
                res += hashMap.get(s.charAt(i));
            }else {
                res -= hashMap.get(s.charAt(i));
            }
        }
        return  res;

    }
}
