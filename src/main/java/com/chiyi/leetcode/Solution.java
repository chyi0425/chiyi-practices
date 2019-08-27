package com.chiyi.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
    
    
   /**
     * 206
     * reverse a singly likned list.
     *
     * @param x
     * @return
     */
        public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    
     /**
     * 9
     * determine whether an integer is a palindrome.An integer is a palindrome when it reads the same backward as forward.
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * given a string, you need to reverse the order of characters in each word within a sentence while still preserving
     * whitespace and initial word order.
     * Input: "Let's take Leetcode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                stack.push(chars[i]);
            } else if (chars[i] == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                if(stack.isEmpty() && sb.charAt(sb.length() - 1) != ' '){
                    sb.append(' ');
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString().trim();
    }

}
