package com.chiyi.leetcode;

import java.util.Stack;

/**
 * @author chiyi
 * @date 2019/8/13.
 */
public class ReverseNodeList {
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

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tempValue = x;
        int y = 0;
        while (tempValue != 0) {
            int temp = tempValue % 10;
            tempValue = tempValue / 10;
            y = y * 10 + temp;
        }
        return x == y;
    }

    public boolean isPalindrome2(int x) {
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
