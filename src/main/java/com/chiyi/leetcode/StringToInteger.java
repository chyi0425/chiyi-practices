package com.chiyi.leetcode;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean positive = true;

        int i = 0;

        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            positive = false;
            i++;
        }

        long tmp = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            tmp = tmp * 10 + (c-'0');
        }
        if (!positive) {
            tmp = -tmp;
        }
        if (tmp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (tmp < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) tmp;
    }
}
