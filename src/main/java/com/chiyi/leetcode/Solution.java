package com.chiyi.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
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
}
