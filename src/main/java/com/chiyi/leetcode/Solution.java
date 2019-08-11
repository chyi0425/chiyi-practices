package com.chiyi.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * given two arrays,write a function to compute their intersection.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        Set<Integer> nums2Set = new HashSet<>(nums2.length);
        for (int num1 : nums1) {
            nums1Set.add(num1);
        }

        for (int num2 : nums2) {
            nums2Set.add(num2);
        }
        int[] result = new int[nums1Set.size()];
        int idx = 0;
        for (Integer num2 : nums2Set) {
            if (nums1Set.contains(num2)) {
                result[idx++] = num2;
            }
        }
        return Arrays.copyOf(result, idx);
    }


    /**
     * 7
     * given a 32-bit signed integer,reverse digits of an integer.
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
//            -2147483648
            // if result*10+pop > INT_MAX (2147483647) result>= INT_MAX/10
            if ((result > Integer.MAX_VALUE/10|| (result == Integer.MAX_VALUE/10 && pop > 7)) ||
                    (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop < -8))) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
