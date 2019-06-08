package com.chiyi.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // if the lowest position is 0, it's not palindrome number
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        return x == reverse(x);

    }

    private int reverse(int x) {
        int revertNum = 0;
        while (x != 0) {
            if (revertNum > Integer.MAX_VALUE / 10) {
                return -1;
            }
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return revertNum;
    }
}
